package com.succulent.wztxy.succulentplants.handbook.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.util.StreamUtils;
import com.succulent.wztxy.succulentplants.databinding.ActivityPlantCategoryBinding;
import com.succulent.wztxy.succulentplants.handbook.adapter.GenusItemAdapter;
import com.succulent.wztxy.succulentplants.handbook.model.SucculentGenus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenusActivity extends PlantCategoryActivity {

    private static final String TAG = "GenusActivity";
    private GenusItemAdapter genusItemAdapter;
    private ActivityPlantCategoryBinding bind;
    private List<SucculentGenus> succulentGenus;
    private Intent intent;
    private int familyId;
    private Map<Integer, String> id2Name;

    @Override
    public ActivityPlantCategoryBinding getBind() {
        return bind;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = super.getBind();
        id2Name = super.getId2Name();
        intent = getIntent();
        familyId = intent.getIntExtra("familyId", -1);
        initData();
        initRecyclerView();
        initLinkTextView();
    }

    private void initLinkTextView() {
        bind.rightArrow1.setVisibility(View.VISIBLE);
        bind.succulentLink2.setText(id2Name.get(familyId));
        bind.succulentLink1.setTextColor(getResources().getColor(R.color.colorPink));
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
        genusItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SpeciesActivity.actionStart(GenusActivity.this,
                        Integer.parseInt(succulentGenus.get(position).getId()),
                        familyId
                );
            }
        });
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
