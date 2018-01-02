package com.example.administrator.datetimepicker;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

// 여기 작성부터 시작

public class MainActivity extends AppCompatActivity {

    TextView textView;
    DateTimePicker dateTimePicker;

    final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY년 MM월 dd일 HH시 mm분");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.timeView);
        dateTimePicker = (DateTimePicker) findViewById(R.id.dateTimePicker);

        dateTimePicker.setOnDateTImePickerChangedListener(new OnDateTimeChangeListener() {
            @Override
            public void onDateTimeChanged(DateTimePicker view, int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minute) {
                Log.e("MainActivity", "1");
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth, hourOfDay, minute);
                textView.setText(dateFormat.format(calendar.getTime()));
            }
        });

        Calendar calendar = Calendar.getInstance();
        calendar.set(dateTimePicker.getYear(), dateTimePicker.getMonth(), dateTimePicker.getDay(), dateTimePicker.getHour(), dateTimePicker.getMinute());
        textView.setText(dateFormat.format(calendar.getTime()));
    }

}
