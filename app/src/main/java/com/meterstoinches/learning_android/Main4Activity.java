package com.meterstoinches.learning_android;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity implements SensorEventListener {
    TextView t3;
    TextView acceleration;
    Sensor accelerometer;
    SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        t3 = findViewById(R.id.t3);
        acceleration=findViewById(R.id.accelerometerTextView);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(this,accelerometer,sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        acceleration.setText
                ("X: "+(int)event.values[0]+"\nY: "+(int)event.values[1]+"\nZ: "+(int)event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
