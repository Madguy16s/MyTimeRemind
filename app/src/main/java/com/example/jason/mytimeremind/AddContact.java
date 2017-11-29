package com.example.jason.mytimeremind;

import android.app.TimePickerDialog;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by jason on 15-Nov-17.
 */

public class AddContact extends AppCompatActivity {
    Spinner timeOpt;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);
        String[] options = TimeZone.getAvailableIDs();
        timeOpt = (Spinner) findViewById(R.id.timespinner);
        ArrayList<String> timelist = new ArrayList<>();
        for (int i = 0; i < options.length; i++) {
            timelist.add(options[i]);
        }
        ArrayAdapter<String> timeAdapt = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, timelist);
        timeOpt.setAdapter(timeAdapt);
    }

    public void startCont(View v) {
        Calendar initialTime = Calendar.getInstance();
        int hour3 = initialTime.get(Calendar.HOUR_OF_DAY);
        int minute3 = initialTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker3 = new TimePickerDialog(AddContact.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker3, int selectedHour3, int selectedMinute3) {
                        Calendar currentTime = Calendar.getInstance();
                        currentTime.set(Calendar.HOUR_OF_DAY, selectedHour3);
                        currentTime.set(Calendar.MINUTE, selectedMinute3);
                        final TextView StartContDisp = (TextView) findViewById(R.id.startcontdisp);
                        StartContDisp.setText(selectedHour3 + ":" + selectedMinute3);

                    }
                }, hour3, minute3, false);
        mTimePicker3.show();
    }

    public void endCont(View v) {
        Calendar initialTime = Calendar.getInstance();
        int hour4 = initialTime.get(Calendar.HOUR_OF_DAY);
        int minute4 = initialTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker4 = new TimePickerDialog(AddContact.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker4, int selectedHour4, int selectedMinute4) {
                        Calendar currentTime = Calendar.getInstance();
                        currentTime.set(Calendar.HOUR_OF_DAY, selectedHour4);
                        currentTime.set(Calendar.MINUTE, selectedMinute4);
                        final TextView EndContDisp = (TextView) findViewById(R.id.endcontdisp);
                        EndContDisp.setText(selectedHour4 + ":" + selectedMinute4);

                    }
                }, hour4, minute4, false);
        mTimePicker4.show();
    }

    public void addContact(View v) {

    }
}
