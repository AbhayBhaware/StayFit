package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SpalashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalash);

        new Handler().postDelayed(() -> {
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

            if (currentUser != null) {
                // ✅ Already logged in
                startActivity(new Intent(SpalashActivity.this, HomeActivity.class));
            } else {
                // ❌ Not logged in
                startActivity(new Intent(SpalashActivity.this, LoginActivity.class));
            }
            finish(); // Don't come back to splash
        }, 3000);

    }
}