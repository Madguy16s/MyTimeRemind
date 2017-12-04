package com.example.jason.mytimeremind;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


/**
 * Created by jason on 15-Nov-17.
 */

public class SettingActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences2;
    public static final String myPreferences2 = "myPref2";
    public static final String UserDispStrtShr = "userdispstrtKey";
    public static final String UserDispEndShr = "userdispendKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);
        sharedPreferences2 = getSharedPreferences(myPreferences2, Context.MODE_PRIVATE);
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
                        UserFreeTime1.setText(selectedHour + ":" + selectedMinute);
                        //shared pref init
                        if (sharedPreferences2.contains(UserDispStrtShr)) {
                            UserFreeTime1.setText(sharedPreferences2.getString(UserDispStrtShr, ""));
                        }
                        //shared pref save
                        String PermDisp1 = UserFreeTime1.getText().toString();
                        SharedPreferences.Editor editor = sharedPreferences2.edit();
                        editor.putString(UserDispStrtShr, PermDisp1);
                        editor.commit();
                        //// TODO: 04-Dec-17 still needs work. sharedPref did not save
                    }
                }, hour1, minute1, false);
        mTimePicker1.show();

    }

    public void SetFree2(View v) {
        Calendar initialTime2 = Calendar.getInstance();
        int hour2 = initialTime2.get(Calendar.HOUR_OF_DAY);
        int minute2 = initialTime2.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker2 = new TimePickerDialog(SettingActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timepicker2, int selectedHour2, int selectedMinute2) {
                        Calendar currentTime2 = Calendar.getInstance();
                        currentTime2.set(Calendar.HOUR_OF_DAY, selectedHour2);
                        currentTime2.set(Calendar.MINUTE, selectedMinute2);
                        final TextView UserFreeTime2 = (TextView) findViewById(R.id.userfreetime2);
                        UserFreeTime2.setText(selectedHour2 + ":" + selectedMinute2);
                        //shared pref
                        if (sharedPreferences2.contains(UserDispEndShr)) {
                            UserFreeTime2.setText(sharedPreferences2.getString(UserDispEndShr, ""));
                        }
                        //shared pref save
                        String PermDisp2 = UserFreeTime2.getText().toString();
                        SharedPreferences.Editor editor = sharedPreferences2.edit();
                        editor.putString(UserDispEndShr, PermDisp2);
                        editor.commit();
                        //// TODO: 04-Dec-17 still needs work. sharedPref did not save
                    }
                }, hour2, minute2, false);
        mTimePicker2.show();
    }
}

