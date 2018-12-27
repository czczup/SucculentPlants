package com.succulent.wztxy.succulentplants.handbook.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.util.StreamUtils;
import com.succulent.wztxy.succulentplants.databinding.ActivityPlantCategoryBinding;
import com.succulent.wztxy.succulentplants.handbook.adapter.SpeciesItemAdapter;
import com.succulent.wztxy.succulentplants.handbook.model.SucculentSpecies;

import java.util.ArrayList;
import java.util.List;

public class SpeciesActivity extends PlantCategoryActivity {

    private static final String TAG = "SpeciesActivity";
    private SpeciesItemAdapter speciesItemAdapter;
    private ActivityPlantCategoryBinding bind;
    private List<SucculentSpecies> succulentSpecies;
    private Intent intent;
    private int genusId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = super.getBind();
        intent = getIntent();
        genusId = intent.getIntExtra("genusId", -1);
        initData();
        initRecyclerView();
    }

    private void initData() {
        succulentSpecies = new ArrayList<>();
        String json = StreamUtils.get(SpeciesActivity.this, R.raw.species);
        List<SucculentSpecies> temp = new Gson().fromJson(json, new TypeToken<List<SucculentSpecies>>(){}.getType());
        for (SucculentSpecies species : temp) {
            if (Integer.parseInt(species.getGenus_id()) == genusId) {
                succulentSpecies.add(species);
            }
        }
    }


    private void initRecyclerView() {
        speciesItemAdapter = new SpeciesItemAdapter(R.layout.item_empty, succulentSpecies);
        speciesItemAdapter.openLoadAnimation();
        speciesItemAdapter.setNotDoAnimationCount(3);
        bind.recyclerView.setAdapter(speciesItemAdapter);
        bind.recyclerView.setLayoutManager(new LinearLayoutManager(SpeciesActivity.this));
        bind.recyclerView.setNestedScrollingEnabled(false);
    }


    public static void actionStart(Context context, int genusId) {
        Intent intent = new Intent(context, SpeciesActivity.class);
        intent.putExtra("genusId", genusId);
        context.startActivity(intent);
    }
}
