package com.example.administrator.news;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018-01-02.
 */

public class RSSListAdapter extends BaseAdapter {
    ArrayList<NewsItem> ItemList = new ArrayList<NewsItem>();
    Context mContext;

    public RSSListAdapter(Context context) {
        super();
        mContext = context;
    }

    public void addItem(NewsItem item) {
        ItemList.add(item);
    }

    @Override
    public int getCount() {
        return ItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return ItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsItemView view = new NewsItemView(mContext);

        NewsItem item = ItemList.get(position);

        view.setImage(item.getIcon());
        view.setTitle(item.getTitle());
        view.setDate(item.getPubDate());
        view.setCategory(item.getCategory());

        view.setTextToWebView(item.getDescription());

        return view;
    }
}
