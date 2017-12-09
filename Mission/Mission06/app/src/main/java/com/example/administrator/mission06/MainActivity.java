package com.example.administrator.mission06;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("로그인하기");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        id = (EditText) findViewById(R.id.user_id);
        pw = (EditText) findViewById(R.id.user_password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = id.getText().toString();
                String userPw = pw.getText().toString();

                if (userId.equals("")) {
                    Toast.makeText(getApplicationContext(), "아이디를 입력해주세요", Toast.LENGTH_LONG).show();
                    id.requestFocus();
                } else if (userPw.equals("")) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요", Toast.LENGTH_LONG).show();
                    pw.requestFocus();
                } else {
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivityForResult(intent, 101);
                    Toast.makeText(getApplicationContext(), userId + "님 반갑습니다", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if(intent!=null) {
            String result = intent.getStringExtra("select").toString();
            Toast.makeText(this, result+"부터 호출", Toast.LENGTH_LONG).show();
            id.setText("");
            pw.setText("");
            id.setHint("아이디");
            pw.setHint("비밀번호");
            id.requestFocus();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 101) {
            String result = data.getStringExtra("select").toString();
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        }
    }
}
