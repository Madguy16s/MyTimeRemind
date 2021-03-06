package com.example.jason.mytimeremind;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimeZone rn = TimeZone.getDefault();
        final TextView userTime = (TextView) findViewById(R.id.yourtimezone);
        userTime.setText("Your TimeZone is " + rn.getDisplayName(false, TimeZone.LONG));
    }

    public void addCont(View v) {
        Intent adds = new Intent(this, AddContact.class);
        startActivity(adds);
    }

    public void setBtn(View v) {
        Intent sets = new Intent(this, SettingActivity.class);
        startActivity(sets);
    }

}
