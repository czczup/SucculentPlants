package com.succulent.wztxy.succulentplants.handbook.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.just.agentweb.AgentWeb;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.databinding.ActivityInformationBinding;

public class InformationActivity extends BaseActivity {

    ActivityInformationBinding bind;
    private static final String TAG = "InformationActivity";
    private Intent intent;
    private String keyword;
    protected AgentWeb mAgentWeb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_information);
        initImmersionBar();
        intent = getIntent();
        keyword = intent.getStringExtra("keyword");
        Log.d(TAG, "onCreate: "+ keyword);
        initToolBar();
        initEvent();
        initView();
    }

    private void initView() {
        String keyword = intent.getStringExtra("keyword");
        mAgentWeb = AgentWeb.with(this)//传入Activity
                .setAgentWebParent(bind.linearLayout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()// 使用默认进度条
                .createAgentWeb()//
                .ready()
                .go("https://baike.baidu.com/item/"+keyword);
    }

    private void initEvent() {
        bind.toolbar.setNavigationOnClickListener(view -> finish());
    }

    private void initToolBar() {
        bind.textView.setText(keyword);
    }


    protected void initImmersionBar() {
        //在BaseActivity里初始化
        ImmersionBar.with(this)
                .navigationBarColor(R.color.colorPrimary)
                .statusBarColor(R.color.colorWhite)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)
                .init();
    }

    public static void actionStart(Context context, String keyword) {
        Intent intent = new Intent(context, InformationActivity.class);
        intent.putExtra("keyword", keyword);
        context.startActivity(intent);
    }
}
