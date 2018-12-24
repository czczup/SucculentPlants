package com.succulent.wztxy.succulentplants.mine.activity.contribution;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.databinding.ActivityMyContributionBinding;
import com.succulent.wztxy.succulentplants.mine.fragment.contribution.InReviewFragment;
import com.succulent.wztxy.succulentplants.mine.fragment.contribution.NotPassFragment;
import com.succulent.wztxy.succulentplants.mine.fragment.contribution.PassFragment;

import java.util.ArrayList;


public class MyContributionActivity extends BaseActivity {

    private ActivityMyContributionBinding bind;
    private String[] titles = new String[]{"审核中", "未通过", "已通过"};
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private FmPagerAdapter pagerAdapter;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_my_contribution);
        initImmersionBar();
        initView();
        initEvent();
    }

    private void initEvent() {
        bind.myContributionToolbar.setNavigationOnClickListener(view -> finish());
    }

    private void initView() {
        InReviewFragment inReviewFragment = new InReviewFragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.inReview));
        inReviewFragment.setArguments(bundle);
        fragments.add(inReviewFragment);

        NotPassFragment notPassFragment = new NotPassFragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.notPass));
        notPassFragment.setArguments(bundle);
        fragments.add(notPassFragment);

        PassFragment passFragment = new PassFragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.pass));
        passFragment.setArguments(bundle);
        fragments.add(passFragment);

        bind.tabLayout.addTab(bind.tabLayout.newTab());
        bind.tabLayout.addTab(bind.tabLayout.newTab());
        bind.tabLayout.addTab(bind.tabLayout.newTab());
        bind.tabLayout.setupWithViewPager(bind.viewpager, false);
        pagerAdapter = new FmPagerAdapter(getSupportFragmentManager());
        bind.viewpager.setAdapter(pagerAdapter);

        for(int i = 0; i < titles.length; i++) {
            bind.tabLayout.getTabAt(i).setText(titles[i]);
        }

    }

    protected void initImmersionBar() {
        //在BaseActivity里初始化
        ImmersionBar.with(this)
                .navigationBarColor(R.color.colorPrimary)
                .statusBarColor(R.color.colorWhite)
                .statusBarDarkFont(true, 0.2f)
                .fitsSystemWindows(true)
                .init();
    }


    class FmPagerAdapter extends FragmentPagerAdapter {
        public FmPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

    }

}
