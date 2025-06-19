package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

    EditText e1_name, e2_mobile, e3_email, e4_pass;

    Button b1_signup;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        mAuth=FirebaseAuth.getInstance();
        e1_name=findViewById(R.id.Name);
        e2_mobile=findViewById(R.id.Mobile);
        e3_email=findViewById(R.id.Email);
        e4_pass=findViewById(R.id.Password);

        b1_signup=findViewById(R.id.Signup);

        b1_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }
    void registerUser()
    {
        if (!isConnected()) {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            return;
        }

        String name=e1_name.getText().toString();
        String mobile=e2_mobile.getText().toString();
        String email=e3_email.getText().toString();
        String password=e4_pass.getText().toString();

        if (name.isEmpty())
        {
            Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if (name.length()<5) {
            Toast.makeText(this, "Name is Too Short", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mobile.isEmpty())
        {
            Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mobile.length()<10) {
            Toast.makeText(this, "Mobile Number is Wrong", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mobile.length()>10) {
            Toast.makeText(this, "Mobile Number is Wrong", Toast.LENGTH_SHORT).show();
            return;
        }
        if (email.isEmpty())
        {
            Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.isEmpty()) {
            Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length()<5) {
            Toast.makeText(this, "Password is Too Short", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful())
            {
                FirebaseUser user=mAuth.getCurrentUser();
                Toast.makeText(this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
            else
            {
                Toast.makeText(this, "Failed To Signup", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

}