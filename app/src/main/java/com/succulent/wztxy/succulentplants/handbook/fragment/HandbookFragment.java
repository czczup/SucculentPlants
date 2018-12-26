package com.succulent.wztxy.succulentplants.handbook.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.fragment.BaseFragment;
import com.succulent.wztxy.succulentplants.databinding.FragmentHandbookBinding;
import com.succulent.wztxy.succulentplants.handbook.activity.InformationActivity;

import java.util.ArrayList;
import java.util.List;

public class HandbookFragment extends BaseFragment {
    FragmentHandbookBinding bind;
    private List<TextView> historyItems;
    private List<TextView> hotItems;
    private List<String> historyTitles;
    private List<String> hotTitles;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_handbook, null);
        bind = DataBindingUtil.bind(view);
        initImmersionBar();
        initHistorySearchItems();
        initHotItems();
        return view;
    }

    private void initHotItems() {
        hotItems = new ArrayList<>();
        hotItems.add(bind.firstHotItems.findViewById(R.id.item_left));
        hotItems.add(bind.firstHotItems.findViewById(R.id.item_middle));
        hotItems.add(bind.firstHotItems.findViewById(R.id.item_right));
        hotItems.add(bind.secondHotItems.findViewById(R.id.item_left));
        hotItems.add(bind.secondHotItems.findViewById(R.id.item_middle));
        hotItems.add(bind.secondHotItems.findViewById(R.id.item_right));
        hotTitles = new ArrayList<>();
        hotTitles.add("八千代");
        hotTitles.add("虹之玉锦");
        hotTitles.add("芙蓉雪莲");
        hotTitles.add("黑莓");
        hotTitles.add("红粉佳人");
        hotTitles.add("红化妆");
        setText(hotTitles, hotItems);
//        addOnClickListener(hotItems);
    }

    private void addOnClickListener(List<TextView> items) {
        for (TextView tv : items) {
            tv.setOnClickListener(v -> {
                InformationActivity.actionStart(getContext(), tv.getText().toString());
            });
        }
    }

    private void initHistorySearchItems() {
        historyItems = new ArrayList<>();
        historyItems.add(bind.firstSearchItems.findViewById(R.id.item_left));
        historyItems.add(bind.firstSearchItems.findViewById(R.id.item_middle));
        historyItems.add(bind.firstSearchItems.findViewById(R.id.item_right));
        historyItems.add(bind.secondSearchItems.findViewById(R.id.item_left));
        historyItems.add(bind.secondSearchItems.findViewById(R.id.item_middle));
        historyItems.add(bind.secondSearchItems.findViewById(R.id.item_right));
        historyTitles = new ArrayList<>();
        historyTitles.add("蓝石莲");
        historyTitles.add("虹之玉");
        historyTitles.add("厚叶月影");
        historyTitles.add("白牡丹");
        historyTitles.add("冰梅");
        historyTitles.add("橙梦露");
        setText(historyTitles, historyItems);
//        addOnClickListener(hotItems);
    }

    private void setText(List<String> titles, List<TextView> items) {
        for (int i = 0; i < titles.size(); i++) {
            items.get(i).setText(titles.get(i));
        }
    }


    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)
                .init();
    }
}
