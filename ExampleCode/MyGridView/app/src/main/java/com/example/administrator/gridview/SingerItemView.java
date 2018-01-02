package com.example.administrator.gridview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView extends LinearLayout {

    ImageView photo;
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
        inflater.inflate(R.layout.item_view, this, true);   // false로 하면 item_view가 drawen되지 않아 이벤트 처리 불가.
        // inflater.inflate(R.layout.item_view, this); // 다른 메소드로 오버라이딩 해도 (책에 나와있는 방법, 3번째 인자 제외)

        photo = (ImageView) findViewById(R.id.profile_image);
        phone = (TextView) findViewById(R.id.profile_cellNumer);
        name = (TextView) findViewById(R.id.profile_name);
        age = (TextView) findViewById(R.id.profile_age);

    }

    public void setPhoto(int resId) {
        photo.setImageResource(resId);
    }

    public void setName(String input_name) {
        name.setText(input_name);
    }

    public void setPhone(String cellphone) {
        Log.e("SingerItemView before", cellphone);
        phone.setText(cellphone);
        Log.e("SingerItemView after", cellphone);
    }

    public void setAge(int input_age) {
        age.setText(String.valueOf(input_age));
    }

}
