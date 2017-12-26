package com.example.administrator.mission07;

import android.app.DatePickerDialog;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    Calendar calendar;
    Button dateBtn, saveBtn;
    EditText editname, editage;
    String date, name, age;
    int year, month, day;
    DatePickerDialog datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateBtn = (Button) findViewById(R.id.set_date);
        saveBtn = (Button) findViewById(R.id.save_date);
        editname = (EditText) findViewById(R.id.edit_name);
        editage = (EditText) findViewById(R.id.edit_age);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);

        date = new String(year + "년 " + month + "월 " + day + "일");
        dateBtn.setText(year + "년 " + month + "월 " + day + "일");


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editname.getText().toString().trim();
                age = editage.getText().toString().trim();
                Toast.makeText(getApplicationContext(), "1. 이름 : " + name + "\n2. 나이 : " + age + "\n3. 생년월일 : " + date, Toast.LENGTH_LONG).show();
            }
        });

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();

                datePicker.show(getSupportFragmentManager(), "Theme 4");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        date = DateFormat.getDateInstance(DateFormat.FULL).format((c.getTime()));
        dateBtn.setText(date);
    }
}
