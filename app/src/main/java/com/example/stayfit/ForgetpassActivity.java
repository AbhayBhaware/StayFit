package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ForgetpassActivity extends AppCompatActivity {

    EditText e1Email;
    Button b1Forget;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);

        mAuth=FirebaseAuth.getInstance();
        e1Email=findViewById(R.id.forgetEmail);
        b1Forget=findViewById(R.id.forgetBTN);

        b1Forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=e1Email.getText().toString().trim();

                if (TextUtils.isEmpty(email))
                {
                    Toast.makeText(ForgetpassActivity.this, "Enter Your Registered Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(ForgetpassActivity.this, "Password Reset Email Sent", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(ForgetpassActivity.this, "Failed to Send Email", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}