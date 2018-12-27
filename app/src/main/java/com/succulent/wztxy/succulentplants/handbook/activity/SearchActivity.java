package com.succulent.wztxy.succulentplants.handbook.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.databinding.ActivitySearchBinding;

public class SearchActivity extends BaseActivity {
    ActivitySearchBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_search);

        initView();
        initSearchBar();
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

    private void initView() {

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
