package com.example.administrator.mission01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ScrollView scrollView01;
    ScrollView scrollView02;
    ImageView imageView01;
    ImageView imageView02;
    Button upBtn;
    Button downBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView01 = (ScrollView) findViewById(R.id.scrollview01);
        scrollView02 = (ScrollView) findViewById(R.id.scrollview02);
        imageView01 = (ImageView) findViewById(R.id.img01);
        imageView02 = (ImageView) findViewById(R.id.img02);
        upBtn = (Button) findViewById(R.id.upBtn);
        downBtn = (Button) findViewById(R.id.downBtn);

        scrollView01.setHorizontalScrollBarEnabled(true);
        scrollView02.setHorizontalScrollBarEnabled(true);
        scrollView01.setVerticalScrollBarEnabled(true);
        scrollView02.setVerticalScrollBarEnabled(true);

        upBtn.setOnClickListener(this);
        downBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.upBtn) {
            imageView01.setVisibility(View.VISIBLE);
            imageView02.setVisibility(View.INVISIBLE);
        }
        else {
            imageView02.setVisibility(View.VISIBLE);
            imageView01.setVisibility(View.INVISIBLE);
        }

    }
}