package com.succulent.wztxy.succulentplants.handbook.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.util.StreamUtils;
import com.succulent.wztxy.succulentplants.handbook.adapter.FamilyItemAdapter;
import com.succulent.wztxy.succulentplants.databinding.ActivityPlantCategoryBinding;
import com.succulent.wztxy.succulentplants.handbook.model.SucculentFamily;

import java.util.List;

public class FamilyActivity extends PlantCategoryActivity {
    private static final String TAG = "FamilyActivity";
    private FamilyItemAdapter familyItemAdapter;
    private ActivityPlantCategoryBinding bind;
    private List<SucculentFamily> succulentFamilies;

    @Override
    public ActivityPlantCategoryBinding getBind() {
        return bind;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = super.getBind();
        initData();
        initRecyclerView();
    }

    private void initData() {
        String json = StreamUtils.get(FamilyActivity.this, R.raw.family);
        succulentFamilies = new Gson().fromJson(json, new TypeToken<List<SucculentFamily>>(){}.getType());
        Log.d(TAG, "initData: "+succulentFamilies.get(0));
    }


    private void initRecyclerView() {
        familyItemAdapter = new FamilyItemAdapter(R.layout.item_empty, succulentFamilies);
        familyItemAdapter.openLoadAnimation();
        familyItemAdapter.setNotDoAnimationCount(3);
        familyItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                GenusActivity.actionStart(FamilyActivity.this, Integer.parseInt(succulentFamilies.get(position).getId()));
            }
        });
        bind.recyclerView.setAdapter(familyItemAdapter);
        bind.recyclerView.setLayoutManager(new LinearLayoutManager(FamilyActivity.this));
        bind.recyclerView.setNestedScrollingEnabled(false);
    }


    public static void actionStart(Context context) {
        Intent intent = new Intent(context, FamilyActivity.class);
        context.startActivity(intent);
    }
}
