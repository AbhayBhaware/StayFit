package com.example.stayfit;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StepCountFragment extends Fragment implements SensorEventListener {


    private SensorManager sensorManager;
    private Sensor stepSensor;
    private boolean isSensorAvailable;
    private int stepCount = 0;
    private TextView stepCountView, distanceView, caloriesView;

    private SharedPreferences prefs;
    private static final String PREF_NAME = "step_prefs";
    private static final String KEY_DATE = "date";
    private static final String KEY_INITIAL_STEP = "initial_step";
    private int initialStepCount = 0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_step_count, container, false);

        // Initialize views
        stepCountView = v.findViewById(R.id.step_count);
        distanceView = v.findViewById(R.id.distance);
        caloriesView = v.findViewById(R.id.calories);

        // Request permission if not granted
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACTIVITY_RECOGNITION)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 1);
        }

        // Initialize sensor
        sensorManager = (SensorManager) requireActivity().getSystemService(Context.SENSOR_SERVICE);

        if (sensorManager != null) {
            stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isSensorAvailable = stepSensor != null;
        }

        if (!isSensorAvailable) {
            stepCountView.setText("Step Counter Sensor not available!");
        }

        // 🔽 Add this block: Setup SharedPreferences and check for date reset
        prefs = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        String savedDate = prefs.getString(KEY_DATE, "");
        String currentDate = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());

        if (!savedDate.equals(currentDate)) {
            // This is a new day; reset initial steps to 0 for now (real value set onSensorChanged)
            prefs.edit()
                    .putString(KEY_DATE, currentDate)
                    .putInt(KEY_INITIAL_STEP, 0)
                    .apply();
        }

        initialStepCount = prefs.getInt(KEY_INITIAL_STEP, 0);
        // 🔼 End of added block

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
            int todaySteps = stepCount - initialStepCount;

            stepCountView.setText("Steps: " + todaySteps);

            double stepLength = 0.78;
            double distance = todaySteps * stepLength;
            distanceView.setText(String.format("Distance: %.2f m", distance));

            double calories = todaySteps * 0.04;
            caloriesView.setText(String.format("Calories: %.2f kcal", calories));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not needed for step counting
    }


}