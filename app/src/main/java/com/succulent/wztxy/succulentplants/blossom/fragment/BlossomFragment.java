package com.succulent.wztxy.succulentplants.blossom.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.MainActivity;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.blossom.activity.ArticleActivity;
import com.succulent.wztxy.succulentplants.blossom.activity.CategroyArticleActivity;
import com.succulent.wztxy.succulentplants.blossom.adapter.BlossomArticleAdapter;
import com.succulent.wztxy.succulentplants.blossom.model.ArticleItem;
import com.succulent.wztxy.succulentplants.blossom.tool.HttpUtil;
import com.succulent.wztxy.succulentplants.common.fragment.BaseFragment;
import com.succulent.wztxy.succulentplants.common.util.GlideImageLoader;
import com.succulent.wztxy.succulentplants.databinding.FragmentBlossomBinding;
import com.succulent.wztxy.succulentplants.mine.activity.avatar.AvatarActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class BlossomFragment extends BaseFragment {

    private static final String TAG = "BlossomFragment";

    private FragmentBlossomBinding bind;
    private List<String> images;
    private List<ArticleItem> articles;
    private BlossomArticleAdapter blossomArticleAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_blossom, null);
        bind = DataBindingUtil.bind(view);
//        initImmersionBar();
        initNavigationBar();
        initRecyclerView();
        initView();
        initRefreshLayout();
        return view;
    }

    private void initNavigationBar() {
        LinearLayout plantRecommendItem = bind.navigationBar.findViewById(R.id.plantRecommendItem);
        LinearLayout seniorColumnItem = bind.navigationBar.findViewById(R.id.seniorColumnItem);
        LinearLayout interestingPlantsItem = bind.navigationBar.findViewById(R.id.interestingPlantsItem);
        LinearLayout flowerArtLifeItem = bind.navigationBar.findViewById(R.id.flowerArtLifeItem);
        LinearLayout plantsCultivateItem = bind.navigationBar.findViewById(R.id.plantsCultivateItem);
        plantRecommendItem.setOnClickListener((v)->{
            CategroyArticleActivity.actionStart(getActivity(), getString(R.string.plantRecommend));
        });
        seniorColumnItem.setOnClickListener((v)->{
            CategroyArticleActivity.actionStart(getActivity(), getString(R.string.seniorColumn));
        });
        interestingPlantsItem.setOnClickListener((v)->{
            CategroyArticleActivity.actionStart(getActivity(), getString(R.string.interestingPlants));
        });
        flowerArtLifeItem.setOnClickListener((v)->{
            CategroyArticleActivity.actionStart(getActivity(), getString(R.string.flowerArtLife));
        });
        plantsCultivateItem.setOnClickListener((v)->{
            CategroyArticleActivity.actionStart(getActivity(), getString(R.string.plantsCultivate));
        });
    }


    private void initRecyclerView() {
        blossomArticleAdapter = new BlossomArticleAdapter(R.layout.item_article, articles);
        blossomArticleAdapter.openLoadAnimation();
        blossomArticleAdapter.setNotDoAnimationCount(3);
        blossomArticleAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemChildClick: ");
                String contentUrl = articles.get(position).getContent_url();
                ArticleActivity.actionStart(getContext(), contentUrl);
            }
        });
        bind.recyclerView.setAdapter(blossomArticleAdapter);
        bind.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        bind.recyclerView.setNestedScrollingEnabled(false);
        bind.cl.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                bind.swipeLayout.setEnabled(verticalOffset >= 0);
            }
        });

    }

    private void initView() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(bind.toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        images = new ArrayList<>();
        images.add("https://s1.ax1x.com/2018/12/24/FcSiNV.jpg");
        images.add("https://s1.ax1x.com/2018/12/24/FcSFhT.jpg");
        bind.banner.setImageLoader(new GlideImageLoader());
        bind.banner.setImages(images);
        bind.banner.start();
    }

    private void refresh() {
        blossomArticleAdapter.setEnableLoadMore(false);
        HttpUtil.doGet("http://"+getString(R.string.ApiUrl)+"/api/article?keyword=多肉&page=1&type=random", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                articles = gson.fromJson(string, new TypeToken<List<ArticleItem>>(){}.getType());
                getActivity().runOnUiThread(new Runnable() {
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
}
