package com.example.ept;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.Debug;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class Estatisticas extends AppCompatActivity implements SensorEventListener {

    private final String PREFERENCIAS_NAME = "com.example.andro.apt";

    private SensorManager sensorManager;
    private Sensor acelerometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatisticas);

        sensorManager = (SensorManager) getSystemService(this.SENSOR_SERVICE);
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0],
        y = event.values[1],
        z = event.values[2];

        String results = "X: " + String.valueOf(x) + " | Y: " + String.valueOf(y) + " | Z: " + String.valueOf(z);

        Log.v("Sensor", results);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }
}