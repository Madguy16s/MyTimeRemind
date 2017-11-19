package com.example.jason.mytimeremind;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by jason on 15-Nov-17.
 */

public class SettingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);
        final TextView UserFreeTime1 = (TextView) findViewById(R.id.userfreetime1);
    }


    public void SetFree1(View v) {
        Calendar initialTime = Calendar.getInstance();
        int hour1 = initialTime.get(Calendar.HOUR_OF_DAY);
        int minute1 = initialTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker1 = new TimePickerDialog(SettingActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        Calendar currentTime = Calendar.getInstance();
                        currentTime.set(Calendar.HOUR_OF_DAY, selectedHour);
                        currentTime.set(Calendar.MINUTE, selectedMinute);
                        final TextView UserFreeTime1 = (TextView) findViewById(R.id.userfreetime1);
                        UserFreeTime1.setText(selectedHour+":"+selectedMinute);

                    }
                }, hour1, minute1, false);
        mTimePicker1.show();

    }
    public void SetFree2(View v){
        Calendar initialTime2 = Calendar.getInstance();
        int hour2 = initialTime2.get(Calendar.HOUR_OF_DAY);
        int minute2 = initialTime2.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker2 = new TimePickerDialog(SettingActivity.this,
                new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker timepicker2, int selectedHour2, int selectedMinute2){
                        Calendar currentTime2 = Calendar.getInstance();
                        currentTime2.set(Calendar.HOUR_OF_DAY, selectedHour2);
                        currentTime2.set(Calendar.MINUTE, selectedMinute2);
                        final TextView UserFreeTime2 = (TextView)findViewById(R.id.userfreetime2);
                        UserFreeTime2.setText(selectedHour2+":"+selectedMinute2);
                    }
                }, hour2, minute2, false);
        mTimePicker2.show();
    }
}

