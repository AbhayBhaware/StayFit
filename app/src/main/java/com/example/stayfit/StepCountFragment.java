package com.example.stayfit;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StepCountFragment extends Fragment implements SensorEventListener {


    private SensorManager sensorManager;
    private Sensor stepSensor;
    private boolean isSensorAvailable;
    private int stepCount = 0;
    private TextView stepCountView, distanceView, caloriesView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_step_count, container, false);

        stepCountView = v.findViewById(R.id.step_count);
        distanceView = v.findViewById(R.id.distance);
        caloriesView = v.findViewById(R.id.calories);


        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACTIVITY_RECOGNITION)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 1);

        }

        sensorManager = (SensorManager) requireActivity().getSystemService(getContext().SENSOR_SERVICE);

        if (sensorManager != null) {
            stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isSensorAvailable = stepSensor != null;
        }
        if (stepSensor == null) {
            stepCountView.setText("Step Counter Sensor not available!");
        }


        return v;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("StepCounter", "Permission granted!");
            } else {
                Log.d("StepCounter", "Permission denied!");
            }
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        if (isSensorAvailable) {
            sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI);
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        if (isSensorAvailable) {
            sensorManager.unregisterListener(this);
        }
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            stepCount = (int) event.values[0];
            stepCountView.setText("Steps: " + stepCount);

            double stepLength = 0.78; // average in meters
            double distance = stepCount * stepLength; // in meters
            distanceView.setText(String.format("Distance: %.2f m", distance));

            // Calculate calories
            double calories = stepCount * 0.04; // kcal
            caloriesView.setText(String.format("Calories: %.2f kcal", calories));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not needed for step counting
    }


}