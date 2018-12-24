package com.succulent.wztxy.succulentplants.handbook.fragment;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.fragment.BaseFragment;

public class HandbookFragment extends BaseFragment {

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .init();
    }
}
