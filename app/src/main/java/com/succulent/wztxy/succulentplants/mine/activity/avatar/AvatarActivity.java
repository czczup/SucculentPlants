package com.succulent.wztxy.succulentplants.mine.activity.avatar;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.databinding.ActivityAvatarBinding;
import com.succulent.wztxy.succulentplants.common.util.MyOneLineView;

public class AvatarActivity extends BaseActivity implements MyOneLineView.OnRootClickListener {

    private ActivityAvatarBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_avatar);
        initImmersionBar();
        initView();
        initEvent();
    }

    private void initEvent() {
        bind.informationToolbar.setNavigationOnClickListener(view -> finish());
    }

    private void initView() {
        bind.avatarItem.init()
                .setLeftIconSize(0, 0)
                .setRootPadding(0,-10,10,10)
                .setIvRightIcon(R.mipmap.avatar1)
                .setOnRootClickListener(this, 0)
                .showEdit(false)
                .setTextContent("头像")
                .setTextContentSize(16);
        bind.nicknameItem.initDoubleText(R.string.infoItem1, R.string.nickname)
                .setOnRootClickListener(this, 1)
                .setTextContentSize(16);
        bind.genderItem.initDoubleText(R.string.infoItem2, R.string.male)
                .setOnRootClickListener(this, 2)
                .setTextContentSize(16);
        bind.introductionItem.initDoubleText(R.string.infoItem3, R.string.introduction)
                .setOnRootClickListener(this, 3)
                .setTextContentSize(16);
    }

    @Override
    public void onRootClick(View view) {
        Intent intent = new Intent();
        switch ((int) view.getTag()) {
            case 0:
                intent.setClass(this, ChangeAvatarActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent.setClass(this, ChangeNicknameActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent.setClass(this, ChangeGenderActivity.class);
                intent.putExtra("gender", bind.genderItem.getRightTextContent());
                startActivity(intent);
                break;
            case 3:
                intent.setClass(this, ChangeIntroductionActivity.class);
                startActivity(intent);
                break;
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
}
