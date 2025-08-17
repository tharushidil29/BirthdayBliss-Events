package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_setting_page);
        // Initialize the switch for screen rotation control
        Switch rotationSwitch = findViewById(R.id.switcher);
        // Set an OnCheckedChangeListener for the switch
        rotationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // If the switch is checked, allow screen rotation
                if (isChecked) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                } else {
                    // otherwise, lock the screen orientation
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
                }
            }
        });
    }
}