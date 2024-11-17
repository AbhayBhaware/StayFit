package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText e1_name, e2_mobile, e3_email, e4_pass;

    Button b1_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        e1_name=findViewById(R.id.Name);
        e2_mobile=findViewById(R.id.Mobile);
        e3_email=findViewById(R.id.Email);
        e4_pass=findViewById(R.id.Password);

        b1_signup=findViewById(R.id.Signup);

        b1_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1_name.getText().toString().isEmpty())
                {
                    e1_name.setError("Name Cannot Be Null");
                } else if (e1_name.getText().toString().length()<5) {
                    e1_name.setError("Name Must Be Greater Than 5 Letters");
                }
                else if (e2_mobile.getText().toString().isEmpty())
                {
                    e2_mobile.setError("Mobile Number Cannot Be Null");
                } else if (e2_mobile.getText().toString().length()<10) {
                    e2_mobile.setError("Number Cannot Be Less Than 10 Digits");
                }
                else if (e2_mobile.getText().toString().length()>10) {
                    e2_mobile.setError("Number Cannot Be Greater Than 10 Digits");
                }
                else if (e3_email.getText().toString().isEmpty())
                {
                    e2_mobile.setError("Email Cannot Be Null");
                } else if (e4_pass.getText().toString().isEmpty()) {
                    e4_pass.setError("Password Cannot Be Null");

                } else if (e4_pass.getText().toString().length()<5) {
                    e4_pass.setError("Password Must Be Greater Than 5 Digits");
                }
                else
                {
                    Intent i=new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(SignupActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}