package com.succulent.wztxy.succulentplants.blossom.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.blossom.adapter.BlossomArticleAdapter;
import com.succulent.wztxy.succulentplants.blossom.model.ArticleItem;
import com.succulent.wztxy.succulentplants.blossom.tool.HttpUtil;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.databinding.ActivityCategroyArticleBinding;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CategroyArticleActivity extends BaseActivity {

    private ActivityCategroyArticleBinding bind;
    private BlossomArticleAdapter blossomArticleAdapter;
    private List<ArticleItem> articles;
    private static final String TAG = "CategroyArticleActivity";
    private String categroy;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categroy_article);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_categroy_article);
        intent = getIntent();
        categroy = intent.getStringExtra("categroy");
        Log.d(TAG, "onCreate: "+categroy);
        initImmersionBar();
        initView();
        initEvent();
        initRecyclerView();
        initRefreshLayout();
    }

    private void initRecyclerView() {
        blossomArticleAdapter = new BlossomArticleAdapter(R.layout.item_article, articles);
        blossomArticleAdapter.openLoadAnimation();
        blossomArticleAdapter.setNotDoAnimationCount(3);
        blossomArticleAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String contentUrl = articles.get(position).getContent_url();
                ArticleActivity.actionStart(CategroyArticleActivity.this, contentUrl);
            }
        });
        bind.recyclerView.setAdapter(blossomArticleAdapter);
        bind.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bind.recyclerView.setNestedScrollingEnabled(false);

    }

    private void initEvent() {
        bind.articleToolbar.setNavigationOnClickListener(view -> finish());
    }

    private void initView() {
        Intent intent = getIntent();
        String categroy = intent.getStringExtra("categroy");
        bind.textView.setText(categroy);
    }


    public static void actionStart(Context context, String categroy) {
        Intent intent = new Intent(context, CategroyArticleActivity.class);
        intent.putExtra("categroy", categroy);
        context.startActivity(intent);
    }

    private void refresh() {
        blossomArticleAdapter.setEnableLoadMore(false);
        HttpUtil.doGet("http://"+getString(R.string.ApiUrl)+"/api/article?keyword="+categroy+"&page=1&type=none", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                articles = gson.fromJson(string, new TypeToken<List<ArticleItem>>(){}.getType());
                CategroyArticleActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initRecyclerView();
                        blossomArticleAdapter.setEnableLoadMore(true);
                        bind.swipeLayout.setRefreshing(false);
                    }
                });
            }
        });
    }

    private void initRefreshLayout() {
        bind.swipeLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        bind.swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
        bind.swipeLayout.setRefreshing(true);
        refresh();
    }
    
    
    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)
                .barColor(R.color.colorWhite)
                .init();
    }

}
