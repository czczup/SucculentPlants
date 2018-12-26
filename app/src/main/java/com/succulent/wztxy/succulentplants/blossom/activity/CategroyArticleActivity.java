package com.succulent.wztxy.succulentplants.blossom.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.databinding.ActivityCategroyArticleBinding;

public class CategroyArticleActivity extends BaseActivity {

    private ActivityCategroyArticleBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categroy_article);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_categroy_article);
        initImmersionBar();
        initView();
        initEvent();
    }

    private void initEvent() {
        bind.articleToolbar.setNavigationOnClickListener(view -> finish());
    }

    private void initView() {
        Intent intent = getIntent();
        String categroy = intent.getStringExtra("categroy");


    }


    public static void actionStart(Context context, String categroy) {
        Intent intent = new Intent(context, CategroyArticleActivity.class);
        intent.putExtra("contentUrl", categroy);
        context.startActivity(intent);
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
