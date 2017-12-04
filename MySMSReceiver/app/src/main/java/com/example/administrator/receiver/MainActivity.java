package com.example.administrator.receiver;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);

        if(permission == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "SMS 수신 권한 주어짐", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "SMS 수신 권한 주어지지 않음", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, 1);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if(grantResults.length > 0) {
                    if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "SMS 수신 권한 주어짐", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(this, "사용자가 수신 권한 거부함", Toast.LENGTH_LONG).show();
                }
        }
    }
}
