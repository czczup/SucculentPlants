package com.succulent.wztxy.succulentplants.handbook.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.fragment.BaseFragment;
import com.succulent.wztxy.succulentplants.databinding.FragmentSearchBinding;

public class SearchFragment extends BaseFragment {

    FragmentSearchBinding bind;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_search, null);
        bind = DataBindingUtil.bind(view);
//        initHistorySearchItems();
//        initHotItems();
//        initSearchBar();
        return view;
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
