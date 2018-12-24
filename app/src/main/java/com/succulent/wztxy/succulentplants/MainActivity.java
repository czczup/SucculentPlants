package com.succulent.wztxy.succulentplants;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.succulent.wztxy.succulentplants.blossom.fragment.BlossomFragment;
import com.succulent.wztxy.succulentplants.common.activity.BaseActivity;
import com.succulent.wztxy.succulentplants.common.util.NoScrollViewPager;
import com.succulent.wztxy.succulentplants.databinding.ActivityMainBinding;
import com.succulent.wztxy.succulentplants.handbook.fragment.HandbookFragment;
import com.succulent.wztxy.succulentplants.mine.fragment.MineFragment;
import com.succulent.wztxy.succulentplants.parterre.fragment.ParterreFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding bind;
    private VpAdapter adapter;

    // collections
    private List<Fragment> fragments;// used for ViewPager adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();
        initView();
        initEvent();
    }


    /**
     * create fragments
     */
    private void initData() {
        fragments = new ArrayList<>(4);

        // create ic_blossom_24dp fragment and add it
        BlossomFragment blossomFragment = new BlossomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", getString(R.string.blossom));
        blossomFragment.setArguments(bundle);

        // create handbook fragment and add it
        HandbookFragment handbookFragment = new HandbookFragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.handbook));
        handbookFragment.setArguments(bundle);

        // create parterre fragment and add it
        ParterreFragment parterreFragment = new ParterreFragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.parterre));
        parterreFragment.setArguments(bundle);

        // create mine fragment and add it
        MineFragment mineFragment = new MineFragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.mine));
        mineFragment.setArguments(bundle);

        // add to fragments for adapter
        fragments.add(blossomFragment);
        fragments.add(handbookFragment);
        fragments.add(parterreFragment);
        fragments.add(mineFragment);
    }


    /**
     * change BottomNavigationViewEx style
     */
    private void initView() {
        bind.bnve.enableItemShiftingMode(false);
        bind.bnve.enableShiftingMode(false);
        bind.bnve.enableAnimation(false);

        // set adapter
        adapter = new VpAdapter(getSupportFragmentManager(), fragments);
        bind.vp.setAdapter(adapter);
        bind.vp.setNoScroll(true);

    }

    /**
     * set listeners
     */
    private void initEvent() {
        // set listener to change the current item of view pager when click bottom nav item
        bind.bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            private int previousPosition = -1;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int position = 0;
                switch (item.getItemId()) {
                    case R.id.i_blossom:
                        position = 0;
                        break;
                    case R.id.i_handbook:
                        position = 1;
                        break;
                    case R.id.i_parterre:
                        position = 2;
                        break;
                    case R.id.i_mine:
                        position = 3;
                        break;
                    case R.id.i_empty: {
                        return false;
                    }
                }
                if(previousPosition != position) {
                    bind.vp.setCurrentItem(position, false);
                    previousPosition = position;
                    Log.i(TAG, "-----bnve-------- previous item:" + bind.bnve.getCurrentItem() + " current item:" + position + " ------------------");
                }

                return true;
            }
        });

        // set listener to change the current checked item of bottom nav when scroll view pager
        bind.vp.addOnPageChangeListener(new NoScrollViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "-----ViewPager-------- previous item:" + bind.bnve.getCurrentItem() + " current item:" + position + " ------------------");
                if (position >= 2)// 2 is center
                    position++;// if page is 2, need set bottom item to 3, and the same to 3 -> 4
                bind.bnve.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // center item click listener
        bind.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Center", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * view pager adapter
     */
    private static class VpAdapter extends FragmentPagerAdapter {
        private List<Fragment> data;

        public VpAdapter(FragmentManager fm, List<Fragment> data) {
            super(fm);
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Fragment getItem(int position) {
            return data.get(position);
        }
    }

}
