package com.succulent.wztxy.succulentplants.handbook.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.databinding.ActivityPlantCategoryBinding;


public class PlantCategoryActivity extends BaseActivity {
    private static final String TAG = "PlantCategoryActivity";
    private ActivityPlantCategoryBinding bind;

    public ActivityPlantCategoryBinding getBind() {
        return bind;
    }

    public void setBind(ActivityPlantCategoryBinding bind) {
        this.bind = bind;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_plant_category);
        initEvent();
        initSearchBar();
    }

    private void initEvent() {
        bind.toolbar.setNavigationOnClickListener(view -> finish());
    }

    @Override
    public void initImmersionBar() {
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)
                .barColor(R.color.colorWhite)
                .init();
    }

    private void initSearchBar() {
        bind.searchBar.findViewById(R.id.edit_content_search).setOnClickListener(v -> {
            Log.d(TAG, "initSearchBar: click");
            SearchActivity.actionStart(PlantCategoryActivity.this);
        });
    }
}
