package com.succulent.wztxy.succulentplants.parterre.fragment;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.common.fragment.BaseFragment;

public class ParterreFragment extends BaseFragment {
    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f)
                .fitsSystemWindows(true)
                .init();
    }
}
