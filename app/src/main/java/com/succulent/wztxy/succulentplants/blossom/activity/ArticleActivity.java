package com.succulent.wztxy.succulentplants.blossom.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;

import com.just.agentweb.AgentWeb;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.databinding.ActivityArticleBinding;

public class ArticleActivity extends BaseActivity {
    private ActivityArticleBinding bind;
    protected AgentWeb mAgentWeb;


    public static void actionStart(Context context, String contentUrl) {
        Intent intent = new Intent(context, ArticleActivity.class);
        intent.putExtra("contentUrl", contentUrl);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_article);
        initImmersionBar();
        initView();
        initEvent();
    }

    private void initEvent() {
        bind.articleToolbar.setNavigationOnClickListener(view -> finish());
    }

    private void initView() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("contentUrl");
        mAgentWeb = AgentWeb.with(this)//传入Activity
                .setAgentWebParent(bind.linearLayout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()// 使用默认进度条
                .createAgentWeb()//
                .ready()
                .go(url);
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
