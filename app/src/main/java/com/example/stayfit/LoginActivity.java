package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText e1_username,e2_password;
    Button b1_login,b2_signpage;
    TextView t1_forgetpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loadData();
        if(loadData()==true)
        {
            Intent i=new Intent(LoginActivity.this,TakeWeiHigActivity.class);
            startActivity(i);
            finish();
        }

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
                    saveData();


                    String username =e1_username.getText().toString();
                    if(!username.isEmpty())
                    {
                        SharedPreferences sharedPreferences=getSharedPreferences("MyAppPrefs",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("username",username);
                        editor.apply();
                    }


                    Intent i=new Intent(LoginActivity.this,TakeWeiHigActivity.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();


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
    public void saveData()
    {
        SharedPreferences preferences=getSharedPreferences("sharedPref",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("Flag",true);
        editor.apply();
    }
    public boolean loadData()
    {
        SharedPreferences preferences=getSharedPreferences("sharedPref",MODE_PRIVATE);
        boolean myKey=preferences.getBoolean("Flag",false);
        return myKey;
    }


}