package com.succulent.wztxy.succulentplants.mine.activity.history;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.databinding.ActivityRecognitionHistoryBinding;


public class RecognitionHistoryActivity extends BaseActivity {
    private ActivityRecognitionHistoryBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_recognition_history);
        initImmersionBar();
        initView();
        initEvent();
    }

    private void initEvent() {
        bind.recognitionHistoryToolbar.setNavigationOnClickListener(view -> finish());
    }

    private void initView() {

    }

    protected void initImmersionBar() {
        //在BaseActivity里初始化
        ImmersionBar.with(this)
                .navigationBarColor(R.color.colorPrimary)
                .statusBarColor(R.color.colorWhite)
                .statusBarDarkFont(true, 0.2f)
                .fitsSystemWindows(true)
                .init();
    }
}
