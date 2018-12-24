package com.succulent.wztxy.succulentplants.mine.activity.roast;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.databinding.ActivityRoastBinding;

public class RoastActivity extends BaseActivity {

    private ActivityRoastBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_roast);
        initImmersionBar();
        initView();
        initEvent();
    }

    private void initEvent() {
        bind.roastToolbar.setNavigationOnClickListener(view -> finish());
        bind.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bind.adviceItem.getEditContent().length() == 0) {
                    Toast.makeText(RoastActivity.this, R.string.emptyAdviceHint, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initView() {
        bind.adviceItem.initEditView(R.string.empty, R.string.adviceHint, 4);
        bind.addressItem.initEditView(R.string.empty, R.string.addressHint, 1);

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
