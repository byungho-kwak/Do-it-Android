package com.example.administrator.mission05;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("로그인하기");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        intent = new Intent(this, MenuActivity.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent, 101);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==101) {
            String result = data.getStringExtra("menu");
            Toast.makeText(getApplicationContext(), result + " 클릭", Toast.LENGTH_LONG).show();
        }
    }
}
