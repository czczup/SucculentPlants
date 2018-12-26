package com.succulent.wztxy.succulentplants.handbook.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.fragment.BaseFragment;

public class SearchFragment extends BaseFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    private void initSearchBar() {
//        EditText editText = bind.searchBar.findViewById(R.id.edit_content);
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if (editText.getText().length() > 0) {
//                    bind.searchBar.findViewById(R.id.clear_icon).setVisibility(View.VISIBLE);
//                } else {
//                    bind.searchBar.findViewById(R.id.clear_icon).setVisibility(View.VISIBLE);
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) { }
//        });
//        ImageView clearIcon = bind.searchBar.findViewById(R.id.clear_icon);
//        clearIcon.setOnClickListener(v -> {
//            clearIcon.setVisibility(View.GONE);
//            editText.setText("");
//        });
//    }
}
