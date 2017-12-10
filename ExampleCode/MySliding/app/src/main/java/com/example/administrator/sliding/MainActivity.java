package com.example.administrator.sliding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout page;
    Button btn;
    Animation translateLeft;
    Animation translateRight;
    boolean isPageOpen;
    SlidingPageAnimationListner listner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        page = (LinearLayout) findViewById(R.id.tabPage);
        page.setVisibility(View.INVISIBLE);

        listner = new SlidingPageAnimationListner();

        translateLeft = AnimationUtils.loadAnimation(this, R.anim.trans_left);
        translateRight = AnimationUtils.loadAnimation(this, R.anim.trans_right);
        translateLeft.setAnimationListener(listner);
        translateRight.setAnimationListener(listner);

        isPageOpen = false;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isPageOpen) {
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(translateLeft);
                } else {
                    page.startAnimation(translateRight);
                    Toast.makeText(getApplicationContext(), "닫기 버튼 누름", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private class SlidingPageAnimationListner implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (!isPageOpen) {
                btn.setText("닫기");
                isPageOpen = true;
            } else {
                Toast.makeText(getApplicationContext(), "onAnimationEnd", Toast.LENGTH_SHORT).show();
                page.setVisibility(View.INVISIBLE);
                btn.setText("열기");
                isPageOpen = false;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
