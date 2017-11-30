package com.example.administrator.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        TextView textView;
        ScrollView scrollView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);
        scrollView = (ScrollView) findViewById(R.id.scrollView);

        View view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventAction = event.getAction();

                float curX = event.getX();
                float curY = event.getY();

                if (eventAction == MotionEvent.ACTION_UP) {
                    println("손가락 뗌 : " + curX + ", " + curY);
                } else if(eventAction == MotionEvent.ACTION_DOWN) {
                    println("손가락 누름 : " + curX + ", " + curY);
                } else if(eventAction == MotionEvent.ACTION_MOVE) {
                    println("손가락 움직임 : " + curX + ", " + curY);
                }
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                return true;
            }
        });

    }

    private void println(String data) {
        textView.append(data + "\n");
    }
}
