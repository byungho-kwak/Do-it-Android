package com.example.administrator.mission06;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("메인 메뉴");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                intent = new Intent(this, CustomActivity.class);
                break;
            case R.id.button2:
                intent = new Intent(this, RevenueActivity.class);
                break;
            case R.id.button3:
                intent = new Intent(this, ProductActivity.class);
                break;
        }
        startActivityForResult(intent, 102);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 102 || resultCode == 103 || resultCode == 104) {
            String result = data.getStringExtra("select").toString();
            Toast.makeText(this, result + "부터 호출", Toast.LENGTH_LONG).show();
        }
    }
}
