package com.succulent.wztxy.succulentplants.mine.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.fragment.BaseFragment;
import com.succulent.wztxy.succulentplants.databinding.FragmentMineBinding;
import com.succulent.wztxy.succulentplants.mine.activity.avatar.AvatarActivity;
import com.succulent.wztxy.succulentplants.mine.activity.contribution.MyContributionActivity;
import com.succulent.wztxy.succulentplants.mine.activity.history.RecognitionHistoryActivity;
import com.succulent.wztxy.succulentplants.mine.activity.roast.RoastActivity;
import com.succulent.wztxy.succulentplants.mine.view.MyOneLineView;


public class MineFragment extends BaseFragment implements MyOneLineView.OnRootClickListener{
    FragmentMineBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get title
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_mine, null);
        // bind view
        binding = DataBindingUtil.bind(view);
//        initImmersionBar();
        initView();
        return view;
    }

    private void initView() {
        binding.avatarItem.initMine(R.mipmap.avatar1, "熊童子饲养员", "", true)
                .setOnRootClickListener(this, 0)
                .setLeftIconSize(50,50)
                .setTextContentSize(20).setRootPaddingTopBottom(20, 20);

        binding.historyItem.initMine(R.drawable.ic_plant1_24dp, "识别历史", "", true)
                .setOnRootClickListener(this, 1)
                .showDivider(true, true);

        binding.contributionItem.initMine(R.drawable.ic_plant2_24dp, "我的贡献", "", true)
                .setOnRootClickListener(this, 2);

        binding.evaluateItem.initMine(R.drawable.ic_plant8_24dp, "不吝好评", "", true)
                .setOnRootClickListener(this, 3);

        binding.roastItem.initMine(R.drawable.ic_plant3_24dp, "我要吐槽", "", true)
                .setOnRootClickListener(this, 4);

        binding.shareItem.initMine(R.drawable.ic_plant4_24dp, "分享多肉图鉴App", "", true)
                .setOnRootClickListener(this, 5);

        binding.aboutItem.initMine(R.drawable.ic_plant6_24dp, "关于我们", "", true)
                .setOnRootClickListener(this, 6);

        binding.logoutItem.initMine(R.drawable.ic_plant7_24dp, "退出登录", "", true)
                .setOnRootClickListener(this, 7)
                .showDivider(true, true);
    }

    @Override
    public void onRootClick(View view) {
        Intent intent = new Intent();
        switch ((int) view.getTag()) {
            case 0:
                intent.setClass(getActivity(), AvatarActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent.setClass(getActivity(), RecognitionHistoryActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent.setClass(getActivity(), MyContributionActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent.setClass(getActivity(), RoastActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void initImmersionBar() {
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)
                .barColor(R.color.colorWhite)
                .init();

    }
}
