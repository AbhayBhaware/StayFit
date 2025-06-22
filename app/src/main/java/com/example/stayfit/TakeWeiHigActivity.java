package com.example.stayfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class TakeWeiHigActivity extends AppCompatActivity {

    Button b1_enter;
    EditText e1_we, e2_hi, e3mobile, e4User;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_wei_hig);

        // Initialize Firebase reference
        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        // Bind UI elements
        b1_enter = findViewById(R.id.enterBu);
        e1_we = findViewById(R.id.weEdit);
        e2_hi = findViewById(R.id.hiEdit);
        e3mobile = findViewById(R.id.mobileKey);
        e4User=findViewById(R.id.Username);

        // Handle button click
        b1_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerEmailonFB();
            }
        });
    }

    // Register data in Firebase if mobile doesn't already exist
    void registerEmailonFB() {
        String mobile = e3mobile.getText().toString().trim();
        String weight = e1_we.getText().toString();
        String height = e2_hi.getText().toString();
        String username=e4User.getText().toString();

        if (mobile.isEmpty() || weight.isEmpty() || height.isEmpty()) {
            Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if mobile already exists
        databaseReference.child(mobile).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Toast.makeText(TakeWeiHigActivity.this, "Mobile already exists", Toast.LENGTH_SHORT).show();
                } else {
                    storeDatainFB(mobile, weight, height, username);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(TakeWeiHigActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Store user data in Firebase and mobile number in SharedPreferences
    public void storeDatainFB(String mobile, String weight, String height, String username) {
        Map<String, String> userData = new HashMap<>();
        userData.put("Height", height);
        userData.put("Weight", weight);
        userData.put("Username", username);

        databaseReference.child(mobile).setValue(userData).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // Save mobile number in SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("mobile", mobile);
                editor.apply();

                Toast.makeText(this, "Data Stored", Toast.LENGTH_SHORT).show();

                // Optional: Navigate to next activity
                // startActivity(new Intent(this, NextActivity.class));
                // finish();
            } else {
                Toast.makeText(this, "Failed to store data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
