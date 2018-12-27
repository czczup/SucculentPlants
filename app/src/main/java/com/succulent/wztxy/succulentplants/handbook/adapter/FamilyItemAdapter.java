package com.succulent.wztxy.succulentplants.handbook.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.common.util.MyOneLineView;
import com.succulent.wztxy.succulentplants.handbook.activity.GenusActivity;
import com.succulent.wztxy.succulentplants.handbook.model.SucculentFamily;


import java.util.List;

public class FamilyItemAdapter extends BaseQuickAdapter<SucculentFamily, BaseViewHolder> implements MyOneLineView.OnRootClickListener {

    public FamilyItemAdapter(int layoutResId, List<SucculentFamily> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SucculentFamily item) {
        LinearLayout linearLayout = helper.getView(R.id.empty_item);
        linearLayout.removeAllViews();
        MyOneLineView myOneLineView = new MyOneLineView(mContext);
        myOneLineView.init(item.getName_cn()+"("+item.getCount_item()+")")
                .setRootPadding(0,15, 10, 10)
                .setOnRootClickListener(this, Integer.parseInt(item.getId()))
                .setTextContentColor(R.color.colorBlack);
        linearLayout.addView(myOneLineView);
    }

    @Override
    public void onRootClick(View view) {
        int familyId = (int)view.getTag();
        Log.d(TAG, "onRootClick: "+familyId);
        GenusActivity.actionStart(view.getContext(), familyId);
    }
}
