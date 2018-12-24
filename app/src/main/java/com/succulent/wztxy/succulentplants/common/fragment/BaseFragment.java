package com.succulent.wztxy.succulentplants.common.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.SimpleImmersionFragment;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.databinding.FragmentBaseBinding;


public class BaseFragment extends SimpleImmersionFragment {
    private String title;
    FragmentBaseBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get title
        title = getArguments().getString("title");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_base, null);
        // bind view
        binding = DataBindingUtil.bind(view);
        binding.tvTitle.setText(title);
        return view;
    }

    @Override
    public void initImmersionBar() {
        ImmersionBar.with(this)
                .keyboardEnable(true)
                .statusBarDarkFont(true, 0.2f)
                .init();
    }
}
