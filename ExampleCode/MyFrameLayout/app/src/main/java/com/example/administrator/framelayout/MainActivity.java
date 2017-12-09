package com.example.administrator.framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;

    int idx=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
    }

    public void onButtonClicked (View v) {
        if(idx==0) {
            imageView2.setVisibility(View.INVISIBLE);
            imageView1.setVisibility(View.VISIBLE);
            idx=1;
        }
        else {
            imageView2.setVisibility(View.VISIBLE);
            imageView1.setVisibility(View.INVISIBLE);
            idx=0;
        }

    }
}
