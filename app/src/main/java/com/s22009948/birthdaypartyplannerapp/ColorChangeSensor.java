package com.s22009948.birthdaypartyplannerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.AsyncQueryHandler;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class ColorChangeSensor extends AppCompatActivity {
    // Declare sensor manager and proximity sensor variables
    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private SensorEventListener proximitySensorListner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_color_change_sensor);

        // Initialize the sensor manager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Get the default proximity
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        //Check if proximity sensor is available
        if(proximitySensor == null){ // Show a toast message and the close the activity if the sensor is not available
            Toast.makeText(this, "proximity Sensor is not Available", Toast.LENGTH_LONG).show();
            finish();
        }
        //Create a sensor event listener for the proximity sensor
        proximitySensorListner = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                // Check the sensor value and change the background color based on proximity
                if(sensorEvent.values[0]<proximitySensor.getMaximumRange()) {
                    // Close proximity set background color to red
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                } else {
                    // Far proximity set background color to green
                  getWindow().getDecorView().setBackgroundColor(Color.GREEN);
              }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
              // Do nothing for accuracy changes
            }
        };
        // Register the sensor event listener with normal delay
        sensorManager.registerListener(proximitySensorListner, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the sensor event listener when the activity is paused
        sensorManager.unregisterListener(proximitySensorListner);
    }
}