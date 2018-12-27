package com.succulent.wztxy.succulentplants.handbook.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.common.util.StreamUtils;
import com.succulent.wztxy.succulentplants.databinding.ActivityPlantCategoryBinding;
import com.succulent.wztxy.succulentplants.handbook.model.SucculentFamily;
import com.succulent.wztxy.succulentplants.handbook.model.SucculentGenus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlantCategoryActivity extends BaseActivity {
    private static final String TAG = "PlantCategoryActivity";
    private ActivityPlantCategoryBinding bind;
    private Map<Integer, String> id2Name;

    public ActivityPlantCategoryBinding getBind() {
        return bind;
    }

    public Map<Integer, String> getId2Name() {
        return id2Name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_plant_category);
        initEvent();
        initSearchBar();
        initData();
    }

    private void initData() {
        id2Name = new HashMap<>();
        String json = StreamUtils.get(PlantCategoryActivity.this, R.raw.family);
        List<SucculentFamily> temp1 = new Gson().fromJson(json, new TypeToken<List<SucculentFamily>>(){}.getType());
        for (SucculentFamily family : temp1) {
            id2Name.put(Integer.parseInt(family.getId()), family.getName_cn());
        }
        json = StreamUtils.get(PlantCategoryActivity.this, R.raw.genus);
        List<SucculentGenus> temp2 = new Gson().fromJson(json, new TypeToken<List<SucculentGenus>>(){}.getType());
        for (SucculentGenus genus : temp2) {
            id2Name.put(Integer.parseInt(genus.getId()), genus.getName_cn());
        }
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
