package com.succulent.wztxy.succulentplants.handbook.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.common.util.StreamUtils;
import com.succulent.wztxy.succulentplants.databinding.ActivitySearchBinding;
import com.succulent.wztxy.succulentplants.handbook.adapter.SpeciesItemAdapter;
import com.succulent.wztxy.succulentplants.handbook.model.SucculentSpecies;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity {
    private static final String TAG = "SearchActivity";
    ActivitySearchBinding bind;
    private List<SucculentSpecies> succulentSpecies;
    private SpeciesItemAdapter speciesItemAdapter;
    private List<SucculentSpecies> results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_search);
        results = new ArrayList<>();
        initData();
        initRecyclerView();
        initSearchBar();
        initEvent();
    }

    private void initEvent() {
        EditText editText = bind.searchBar.findViewById(R.id.edit_content_search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                results = new ArrayList<>();
                String keyword = editText.getText().toString();
                if (keyword.length() > 0) {
                    for (int i = 0; i < succulentSpecies.size(); i++) {
                        if (succulentSpecies.get(i).getName_cn().contains(keyword)) {
                            results.add(succulentSpecies.get(i));
                        }
                    }
                    SearchActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            initRecyclerView();
                        }
                    });
                    Log.d(TAG, "afterTextChanged: "+keyword);
                } else {
                    initRecyclerView();
                }
            }
        });
    }


    private void initSearchBar() {
        EditText editText = bind.searchBar.findViewById(R.id.edit_content_search);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        bind.cancelTextview.setOnClickListener(v -> {
            finish();
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        });
        new Thread(new Runnable() {
            public void run() {
                InputMethodManager inputManager = (InputMethodManager)editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(editText, 0);
                inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            }
        }).start();
    }

    private void initRecyclerView() {
        speciesItemAdapter = new SpeciesItemAdapter(R.layout.item_empty, results);
        speciesItemAdapter.openLoadAnimation();
        speciesItemAdapter.setNotDoAnimationCount(3);
        speciesItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                InformationActivity.actionStart(SearchActivity.this, results.get(position).getName_cn());
            }
        });
        bind.recyclerView.setAdapter(speciesItemAdapter);
        bind.recyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
        bind.recyclerView.setNestedScrollingEnabled(false);
    }

    private void initData() {
        String json = StreamUtils.get(SearchActivity.this, R.raw.species);
        succulentSpecies = new Gson().fromJson(json, new TypeToken<List<SucculentSpecies>>(){}.getType());
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initImmersionBar() {
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)
                .barColor(R.color.colorWhite)
                .init();
    }

}
