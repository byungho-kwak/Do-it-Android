package com.example.administrator.mission06;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class CustomActivity extends AppCompatActivity implements View.OnClickListener {

    Button menu, login;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        setTitle("고객 관리");
        menu = (Button) findViewById(R.id.menu);
        login = (Button) findViewById(R.id.login);

        menu.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent();
        intent.putExtra("select", "고객 관리 화면");
        if(v.getId() == R.id.login) {
            intent.setClass(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        } else {
            setResult(102, intent);
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent();
            intent.putExtra("select", "고객 관리 화면");
            setResult(102, intent);
            finish();
            return true;
        } else {
            return false;
        }
    }
}
