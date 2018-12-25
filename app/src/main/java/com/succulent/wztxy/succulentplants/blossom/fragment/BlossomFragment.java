package com.succulent.wztxy.succulentplants.blossom.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.blossom.adapter.BlossomArticleAdapter;
import com.succulent.wztxy.succulentplants.common.fragment.BaseFragment;
import com.succulent.wztxy.succulentplants.common.util.GlideImageLoader;
import com.succulent.wztxy.succulentplants.databinding.FragmentBlossomBinding;

import java.util.ArrayList;
import java.util.List;

public class BlossomFragment extends BaseFragment {

    private FragmentBlossomBinding bind;
    private List<String> images;
    private List<String> texts;
    private BlossomArticleAdapter blossomArticleAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_blossom, null);
        // bind view
        bind = DataBindingUtil.bind(view);
        initRecyclerView();
        initView();
        return view;
    }

    private void initRecyclerView() {
        texts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            texts.add("测试用例"+i);
        }
        blossomArticleAdapter = new BlossomArticleAdapter(R.layout.item_article, texts);
        bind.recyclerView.setAdapter(blossomArticleAdapter);
        bind.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        bind.recyclerView.setNestedScrollingEnabled(false);
        ((AppCompatActivity) getActivity()).setSupportActionBar(bind.toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void initView() {
        images = new ArrayList<>();
        images.add("https://s1.ax1x.com/2018/12/24/FcSiNV.jpg");
        images.add("https://s1.ax1x.com/2018/12/24/FcSFhT.jpg");
        bind.banner.setImageLoader(new GlideImageLoader());
        bind.banner.setImages(images);
        bind.banner.start();

    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
//                .titleBar(bind.toolbar)
                .init();
    }
}
