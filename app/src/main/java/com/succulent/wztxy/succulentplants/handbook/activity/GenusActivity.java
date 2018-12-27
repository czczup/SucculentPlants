package com.succulent.wztxy.succulentplants.handbook.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.util.StreamUtils;
import com.succulent.wztxy.succulentplants.databinding.ActivityPlantCategoryBinding;
import com.succulent.wztxy.succulentplants.handbook.adapter.GenusItemAdapter;
import com.succulent.wztxy.succulentplants.handbook.model.SucculentGenus;

import java.util.ArrayList;
import java.util.List;

public class GenusActivity extends PlantCategoryActivity {

    private static final String TAG = "GenusActivity";
    private GenusItemAdapter genusItemAdapter;
    private ActivityPlantCategoryBinding bind;
    private List<SucculentGenus> succulentGenus;
    private Intent intent;
    private int familyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = super.getBind();
        intent = getIntent();
        familyId = intent.getIntExtra("familyId", -1);
        initData();
        initRecyclerView();
    }

    private void initData() {
        succulentGenus = new ArrayList<>();
        String json = StreamUtils.get(GenusActivity.this, R.raw.genus);
        List<SucculentGenus> temp = new Gson().fromJson(json, new TypeToken<List<SucculentGenus>>(){}.getType());
        for (SucculentGenus genus : temp) {
            if (Integer.parseInt(genus.getFamily_id()) == familyId) {
                succulentGenus.add(genus);
            }
        }
    }


    private void initRecyclerView() {
        genusItemAdapter = new GenusItemAdapter(R.layout.item_empty, succulentGenus);
        genusItemAdapter.openLoadAnimation();
        genusItemAdapter.setNotDoAnimationCount(3);
        bind.recyclerView.setAdapter(genusItemAdapter);
        bind.recyclerView.setLayoutManager(new LinearLayoutManager(GenusActivity.this));
        bind.recyclerView.setNestedScrollingEnabled(false);
    }


    public static void actionStart(Context context, int familyId) {
        Intent intent = new Intent(context, GenusActivity.class);
        intent.putExtra("familyId", familyId);
        context.startActivity(intent);
    }
}
