package com.succulent.wztxy.succulentplants.blossom.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.blossom.model.ArticleItem;

import java.util.List;

public class BlossomArticleAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public BlossomArticleAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        helper.setText(R.id.item_text, item);
//        helper.setImageResource(R.id.icon, item.getImageResource());
        // 加载网络图片
//        Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
    }
}
