package com.trendmicro.www.lightsensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private TextView lightLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightLevel = (TextView)findViewById(R.id.light_level);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(listener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(sensorManager != null){
            sensorManager.unregisterListener(listener);
        }
    }

    private SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float value = event.values[0];
            lightLevel.setText("Current light level is "+value+" lx"+ "Fist Revise"+"Second Revise in AS"+ "Third Change In GitHub in MySecondBranch");
            lightLevel.setText("Fouth change In AS IDE,then use git to commit and merge");
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
}
