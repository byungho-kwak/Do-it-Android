package com.example.administrator.news;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-01-02.
 */

public class NewsItemView extends LinearLayout {

    ImageView Image;
    TextView title, category, date;
    WebView contents;

    public NewsItemView(Context context) {
        super(context);
        init(context);
    }

    public NewsItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.news_item, this);

        Image = (ImageView) findViewById(R.id.newsImage);
        title = (TextView) findViewById(R.id.newsTitle);
        category = (TextView) findViewById(R.id.newsCategory);
        date = (TextView) findViewById(R.id.newsDate);
        contents = (WebView) findViewById(R.id.newsContents);

        WebSettings webSettings = contents.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    public void setImage(Drawable image) {
        Image.setImageDrawable(image);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setCategory(String category) {
        this.category.setText(category);
    }

    public void setDate(String date) {
        this.date.setText(date);
    }

    public void setTextToWebView(String msg) {
        String outData = msg;
        outData = outData.replace("\"//", "\"http://");
        contents.loadDataWithBaseURL("http://localhost/", outData, "text/html", "utf-8", null);
    }
}
