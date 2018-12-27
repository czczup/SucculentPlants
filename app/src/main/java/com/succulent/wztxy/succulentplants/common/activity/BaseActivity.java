package com.succulent.wztxy.succulentplants.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.content.res.Configuration;
import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 所有子类都将继承这些相同的属性,请在设置界面之后设置
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }
    }

    protected void initImmersionBar() {
        //在BaseActivity里初始化
        ImmersionBar.with(this)
                .navigationBarColor(R.color.colorWhite)
                .init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 必须调用该方法，防止内存泄漏
        if (isImmersionBarEnabled()) {
            ImmersionBar.with(this).destroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (isImmersionBarEnabled()) {
            ImmersionBar.with(this).init();
        }
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }
}