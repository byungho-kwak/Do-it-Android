package com.example.administrator.mission05;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.example.administrator.mission05.R.id.button4;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn2, btn3, btn4;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("메인 메뉴");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);

        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent();
        switch (v.getId()) {
        case R.id.button2:
            intent.putExtra("menu", btn2.getText().toString());
            break;
        case R.id.button3:
            intent.putExtra("menu", btn3.getText().toString());
            break;
        case button4:
            intent.putExtra("menu", btn4.getText().toString());
            break;
        }
        setResult(101, intent);
        finish();
    }
}
