package com.succulent.wztxy.succulentplants.mine.activity.avatar;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.databinding.ActivityChangeIntroductionBinding;
import com.succulent.wztxy.succulentplants.mine.view.MyOneLineView;

public class ChangeIntroductionActivity extends BaseActivity implements MyOneLineView.OnArrowClickListener {

    private ActivityChangeIntroductionBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_change_introduction);
        initImmersionBar();
        initView();
        initEvent();
    }

    private void initEvent() {
        bind.introductionToolbar.setNavigationOnClickListener(view -> finish());
        bind.introductionItem.setOnArrowClickListener(this, 0);
    }

    private void initView() {
        bind.introductionItem.initEditView(R.string.introduction, R.string.hintintroduction);
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
    public void onArrowClick(View view) {
        EditText editText = view.findViewById(R.id.edit_content);
        bind.introductionItem.setEditContent("");
    }
}
