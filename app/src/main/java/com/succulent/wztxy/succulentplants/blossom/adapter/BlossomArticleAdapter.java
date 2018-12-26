package com.succulent.wztxy.succulentplants.blossom.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.succulent.wztxy.succulentplants.R;
import com.succulent.wztxy.succulentplants.blossom.model.ArticleItem;


import java.util.List;

public class BlossomArticleAdapter extends BaseQuickAdapter<ArticleItem, BaseViewHolder> {

    public BlossomArticleAdapter(int layoutResId, List<ArticleItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleItem item) {
        helper.setText(R.id.main_title, item.getTitle());
        helper.setText(R.id.introduction_title, item.getDigest());
        helper.setText(R.id.author,"文/"+item.getAccount_name());
        helper.setText(R.id.category_title, "文章·"+item.getKeyword());
        Glide.with(mContext).load(item.getCover_image()).crossFade().into((ImageView) helper.getView(R.id.cover_image));

        helper.addOnClickListener(R.id.article_card);

//        helper.setText(R.id.item_text, item);
//        helper.setImageResource(R.id.icon, item.getImageResource());
        // 加载网络图片
//        Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv));
    }
}
