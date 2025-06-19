package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class LoginActivity extends AppCompatActivity {

    EditText e1_username,e2_password;
    Button b1_login,b2_signpage;
    TextView t1_forgetpass;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mAuth=FirebaseAuth.getInstance();
        e1_username=findViewById(R.id.Username);
        e2_password=findViewById(R.id.Password);
        b1_login=findViewById(R.id.Login);
        b2_signpage=findViewById(R.id.Signpage);
        t1_forgetpass=findViewById(R.id.Forgotpass);


        b1_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loginUser();
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
    void loginUser()
    {
        String email=e1_username.getText().toString().trim();
        String password=e2_password.getText().toString().trim();

        if (TextUtils.isEmpty(email))
        {
            e1_username.setError("Enter Email");
            return;
        }
        if (TextUtils.isEmpty(password))
        {
            e2_password.setError("Enter Password");
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful())
            {
                FirebaseUser user=mAuth.getCurrentUser();
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(i);
                finish();
            }
            else
            {
                Exception e=task.getException();
                if (e instanceof FirebaseAuthInvalidUserException)
                {
                    Toast.makeText(this, "Email not exists", Toast.LENGTH_SHORT).show();
                }
                else if(e instanceof FirebaseAuthInvalidCredentialsException)
                {
                    Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}