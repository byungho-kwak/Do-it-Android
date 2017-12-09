package com.example.administrator.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        TextView textView;
        ScrollView scrollView;
        GestureDetector gestureDetector;

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

        gestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                println("onDown 호출됨");
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                println("onShowPress 호출됨");
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                println("onSingleTapUp 호출됨");
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                println("onScroll 호출됨 : " + distanceX + ", " + distanceY);
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                println("onLongPress 호출됨");
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                println("onFling 호출됨" + velocityX + ", " + velocityY);
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "back 키를 눌렀습니다.", Toast.LENGTH_LONG).show();
            return true;
        } else {
            return false;
        }
    }


    private void println(String data) {
        textView.append(data + "\n");
    }
}
