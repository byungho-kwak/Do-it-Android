package com.example.administrator.datetimepicker;

import android.content.Context;
import android.icu.util.Calendar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;

/**
 * Created by Administrator on 2017-12-29.
 */

public class DateTimePicker extends LinearLayout {

    private OnDateTimeChangeListener listener;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private CheckBox checkBox;

    public DateTimePicker(Context context) {
        super(context);
        init(context);
    }

    public DateTimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.picker, this, true);

        Calendar calendar = Calendar.getInstance();
        final int curYear = calendar.get(Calendar.YEAR);
        final int curMonth = calendar.get(Calendar.MONTH);
        final int curDay = calendar.get(Calendar.DAY_OF_MONTH);
        final int curHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int curMinute = calendar.get(Calendar.MINUTE);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        datePicker.init(curYear, curMonth, curDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                if(listener!=null) {
                    Log.e("DateTimePicker.java", "onDateChanged");
                    listener.onDateTimeChanged(DateTimePicker.this, year, monthOfYear, dayOfMonth, timePicker.getCurrentHour(), timePicker.getCurrentMinute());
                }
            }
        });

        checkBox = (CheckBox) findViewById(R.id.chBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    timePicker.setEnabled(isChecked);
                    timePicker.setVisibility((checkBox).isChecked()? View.VISIBLE:View.GONE);
                }
            });

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                @Override
                public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                    if(listener!=null) {
                        Log.e("DateTimePicker.java", "onTimeChanged");
                        listener.onDateTimeChanged(DateTimePicker.this, datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), hourOfDay, minute);
                    }
                }
        });
        timePicker.setVisibility(View.GONE);
    }

    public void setOnDateTImePickerChangedListener(OnDateTimeChangeListener dateTimeListener) {
        this.listener = dateTimeListener;
    }

    public int getYear() {
        return datePicker.getYear();
    }
    public int getMonth() {
        return datePicker.getMonth();
    }
    public int getDay() {
        Log.e("day 출력", String.valueOf(datePicker.getDayOfMonth()));
        return datePicker.getDayOfMonth();
    }
    public int getHour() {
        return timePicker.getHour();
    }
    public int getMinute() {
        return timePicker.getMinute();
    }

}
