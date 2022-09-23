package com.example.ept;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Campeonatos extends AppCompatActivity implements SensorEventListener {

    TextView txtResult;

    private SensorManager sensorManager;
    private Sensor acelerometro;
    private double prevForcaTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campeonatos);
        setTitle("Campeonatos");
        txtResult = findViewById(R.id.txtResult);

        sensorManager = (SensorManager) getSystemService(this.SENSOR_SERVICE);
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);

    }

    public void resetCount(View view){
        prevForcaTotal = 0;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0],
                y = event.values[1],
                z = event.values[2];

        String results = "X: " + String.valueOf(x) + " | Y: " + String.valueOf(y) + " | Z: " + String.valueOf(z);
        double forcaTotal = x + y + z;

        if(forcaTotal > prevForcaTotal){
            txtResult.setText(String.valueOf(forcaTotal));
            prevForcaTotal = forcaTotal;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }
}