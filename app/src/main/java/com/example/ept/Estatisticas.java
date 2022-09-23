package com.example.ept;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

//        Log.v("Sensor", results);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

    public void mostrarLocal(View view){
        if(ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                &&
            ActivityCompat.checkSelfPermission(
                    this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_NETWORK_STATE}, 1);
            return;
        }

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        LocationListener locationListener= new Localizacao();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }
    public void mostrarMapa(View view){
        double latitude = -23.562549, longitude = -45.655127;
       Uri location = Uri.parse("geo:" + String.valueOf(latitude) + "," + String.valueOf(longitude) + "?z=14");
       Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
       startActivity(mapIntent);
    }

}

class Localizacao implements LocationListener{
    public static double latitude,
            longitude;

    @Override
    public void onLocationChanged(@NonNull Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();

    }
}