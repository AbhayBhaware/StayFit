package com.example.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TakeWeiHigActivity extends AppCompatActivity {

    Button b1_enter;
    EditText e1_we, e2_hi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_wei_hig);

        loadDataa();
        if(loadDataa()==true)
        {
            Intent i=new Intent(TakeWeiHigActivity.this,HomeActivity.class);
            startActivity(i);
            finish();
        }

        b1_enter=findViewById(R.id.enterBu);
        e1_we=findViewById(R.id.weEdit);
        e2_hi=findViewById(R.id.hiEdit);

        b1_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1_we.getText().toString().isEmpty())
                {
                    e1_we.setError("Error");
                } else if (e2_hi.getText().toString().isEmpty()) {
                    e2_hi.setError("Error");
                }
                else {
                    saveDataa();
                    Intent i = new Intent(TakeWeiHigActivity.this, HomeActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });
    }

    public void saveDataa()
    {
        SharedPreferences preferences=getSharedPreferences("sharedPreff",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("Flag",true);
        editor.apply();
    }

    public boolean loadDataa()
    {
        SharedPreferences preferences=getSharedPreferences("sharedPreff",MODE_PRIVATE);
        boolean myKey=preferences.getBoolean("Flag",false);
        return myKey;
    }

}