package com.example.administrator.listview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SingerItemView extends LinearLayout {

    ImageView profile;
    TextView name;
    TextView phone;
    TextView age;

    public SingerItemView(Context context) {
        super(context);
        init(context);
    }

    public SingerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_view, this);

        profile = (ImageView) findViewById(R.id.profile_image);
        name = (TextView) findViewById(R.id.profile_name);
        phone = (TextView) findViewById(R.id.profile_cellNumer);
        age = (TextView) findViewById(R.id.profile_age);

    }

    public void setProfile(int res) {
        profile.setImageResource(res);
    }

    public void setName(String inputName) {
        name.setText(inputName);
    }

    public void setPhone(String inputPhone) {
        phone.setText(inputPhone);
    }

    public void setAge(int inputAge) {
        age.setText(String.valueOf(inputAge));
    }
}
