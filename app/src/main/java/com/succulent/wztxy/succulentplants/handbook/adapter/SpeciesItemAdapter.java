package com.succulent.wztxy.succulentplants.handbook.adapter;

import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.util.MyOneLineView;
import com.succulent.wztxy.succulentplants.handbook.model.SucculentGenus;
import com.succulent.wztxy.succulentplants.handbook.model.SucculentSpecies;

import java.util.List;

public class SpeciesItemAdapter extends BaseQuickAdapter<SucculentSpecies, BaseViewHolder> implements MyOneLineView.OnRootClickListener {

    public SpeciesItemAdapter(int layoutResId, List<SucculentSpecies> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SucculentSpecies item) {
        LinearLayout linearLayout = helper.getView(R.id.empty_item);
        linearLayout.removeAllViews();
        MyOneLineView myOneLineView = new MyOneLineView(mContext);
        myOneLineView.init(item.getName_cn())
                .setRootPadding(0,15, 10, 10)
                .setOnRootClickListener(this, Integer.parseInt(item.getId()))
                .setTextContentColor(R.color.colorBlack);
        linearLayout.addView(myOneLineView);
    }

    @Override
    public void onRootClick(View view) {

    }
}