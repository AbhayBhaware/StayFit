package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText e1_username,e2_password;
    Button b1_login,b2_signpage;
    TextView t1_forgetpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1_username=findViewById(R.id.Username);
        e2_password=findViewById(R.id.Password);
        b1_login=findViewById(R.id.Login);
        b2_signpage=findViewById(R.id.Signpage);
        t1_forgetpass=findViewById(R.id.Forgotpass);


        b1_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1_username.getText().toString().isEmpty())
                {
                    e1_username.setError("Username cannot be Null");
                } else if (e1_username.getText().toString().length()<5) {
                    e1_username.setError("Username must be Greater than 5 Letters");
                } else if (e2_password.getText().toString().isEmpty()) {
                    e2_password.setError("Password cannot be Null");
                } else if (e2_password.getText().toString().length()<5) {
                    e2_password.setError("Password must be Greater than 5 Letters");
                }
                else {
                    Intent i=new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        b2_signpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(i);
                finish();
            }
        });

        t1_forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,ForgetpassActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}