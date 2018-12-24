package com.succulent.wztxy.succulentplants.mine.activity.avatar;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.databinding.ActivityChangeGenderBinding;
import com.succulent.wztxy.succulentplants.mine.view.MyOneLineView;

public class ChangeGenderActivity extends BaseActivity implements MyOneLineView.OnRootClickListener {
    private ActivityChangeGenderBinding bind;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_change_gender);
        intent = getIntent();
        initImmersionBar();
        initView();
        initEvent();
    }

    private void initEvent() {
        bind.genderToolbar.setNavigationOnClickListener(view -> finish());
        bind.maleItem.setOnRootClickListener(this, 0);
        bind.femaleItem.setOnRootClickListener(this, 1);
    }

    private void initView() {
        bind.maleItem.initDoubleText(R.string.male, R.string.empty)
                .setIvRightIcon(R.drawable.ic_right_24dp)
                .showArrow(false);
        bind.femaleItem.initDoubleText(R.string.female, R.string.empty)
                .setIvRightIcon(R.drawable.ic_right_24dp)
                .showArrow(false);
        if ("男".equals(intent.getStringExtra("gender"))) {
            bind.maleItem.showArrow(true);
        } else {
            bind.femaleItem.showArrow(true);
        }
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

    @Override
    public void onRootClick(View view) {
        Intent intent = new Intent();
        switch ((int) view.getTag()) {
            case 0:
                bind.maleItem.showArrow(true);
                bind.femaleItem.showArrow(false);
                break;
            case 1:
                bind.maleItem.showArrow(false);
                bind.femaleItem.showArrow(true);
                break;
        }
    }
}
