package com.succulent.wztxy.succulentplants.handbook.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.databinding.ActivityInformationBinding;

public class InformationActivity extends BaseActivity {

    ActivityInformationBinding bind;
    private static final String TAG = "InformationActivity";
    private Intent intent;
    private String species;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_information);
        initImmersionBar();
        species = intent.getStringExtra("species");
        Log.d(TAG, "onCreate: "+species);
    }



    protected void initImmersionBar() {
        //在BaseActivity里初始化
        ImmersionBar.with(this)
                .navigationBarColor(R.color.colorPrimary)
                .statusBarColor(R.color.colorWhite)
                .fitsSystemWindows(true)
                .init();
    }

    public static void actionStart(Context context, String species) {
        Intent intent = new Intent(context, InformationActivity.class);
        intent.putExtra("species", species);
        context.startActivity(intent);
    }
}
