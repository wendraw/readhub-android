package com.bihe0832.readhub.module.readhub.news;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.bihe0832.readhub.R;
import com.bihe0832.readhub.framework.Shakeba;
import com.bihe0832.readhub.framework.activity.MainActivity;
import com.bihe0832.readhub.libware.util.TextUtils;
import com.bihe0832.readhub.module.readhub.ReadhubOnClickListener;
import com.bihe0832.readhub.module.readhub.adapter.base.SolidRVBaseAdapter;
import com.bihe0832.readhub.module.readhub.news.request.NewsInfo;

import java.util.List;

public class NewsAdapter extends SolidRVBaseAdapter<NewsInfo> {

    public NewsAdapter(Context context, List<NewsInfo> beans) {
        super(context, beans);
    }

    @Override
    public int getItemLayoutID(int vieWType) {
        return R.layout.com_bihe0832_readhub_item_news;
    }

    @Override
    protected void onItemClick(int position) {
        Intent intent = new Intent(mContext, MainActivity.class);
        NewsInfo info = mBeans.get(position - 1);
        //TODO 逻辑处理
        if(null != info){
            intent.putExtra(MainActivity.INTENT_EXTRA_KEY_ITEM_URL, info.getmUrl());
            intent.putExtra(MainActivity.INTENT_EXTRA_KEY_ITEM_TITLE, info.getmTitle());
            mContext.startActivity(intent);
        }
        // 点击打开链接
    }
    @Override
    protected void onBindDataToView(SolidCommonViewHolder holder, NewsInfo bean) {
        holder.setText(R.id.title, bean.getmTitle());
        holder.setText(R.id.summary, bean.getmSummary());
        String subText = String.format(Shakeba.getInstance().getStringById(R.string.news_desc), bean.getmSiteName(), bean.getmAuthorName(),bean.getmPublishDate());
        holder.setText(R.id.more,subText);

        ReadhubOnClickListener listener = new ReadhubOnClickListener(bean.getmTitle(),bean.getmSummary(),bean.getmUrl());
        holder.getView(R.id.title).setOnClickListener(listener);
        holder.getView(R.id.summary).setOnClickListener(listener);
        holder.getView(R.id.title).setOnLongClickListener(listener);
        holder.getView(R.id.summary).setOnLongClickListener(listener);
    }
}