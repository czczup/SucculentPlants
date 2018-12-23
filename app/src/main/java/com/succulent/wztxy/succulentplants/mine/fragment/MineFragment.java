package com.succulent.wztxy.succulentplants.mine.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.SimpleImmersionFragment;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.databinding.FragmentMineBinding;
import com.succulent.wztxy.succulentplants.fragment.BaseFragment;
import com.succulent.wztxy.succulentplants.mine.view.MyOneLineView;


public class MineFragment extends BaseFragment implements MyOneLineView.OnRootClickListener, MyOneLineView.OnArrowClickListener{
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

        binding.avatarItem.initMine(R.mipmap.avatar1, "熊童子饲养员", "", true)
                .setOnRootClickListener(this, 0)
                .setLeftIconSize(50,50)
                .setTextContentSize(20).setRootPaddingTopBottom(20, 20);

        binding.historyItem.initMine(R.drawable.ic_plant1_24dp, "识别历史", "", true)
                .setOnRootClickListener(this, 1);

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

        return view;
    }

    @Override
    public void onRootClick(View view) {

        int position = 0;
        switch ((int) view.getTag()) {
            case 1:
                position = 1;
                break;
            case 2:
                position = 2;
                break;
        }
        Toast.makeText(getActivity(), "点击了第" + position + "行", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onArrowClick(View view) {

        int position = 0;
        switch ((int) view.getTag()) {
            case 1:
                position = 1;
                break;
            case 2:
                position = 2;
                break;
        }
        Toast.makeText(getActivity(), "点击了第" + position + "行右边的箭头", Toast.LENGTH_SHORT).show();
    }

}
