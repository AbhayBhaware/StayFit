package com.example.stayfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
    EditText e1_we, e2_hi, e3mobile;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_wei_hig);

        databaseReference= FirebaseDatabase.getInstance().getReference("User");
        b1_enter=findViewById(R.id.enterBu);
        e1_we=findViewById(R.id.weEdit);
        e2_hi=findViewById(R.id.hiEdit);
        e3mobile=findViewById(R.id.mobileKey);

        b1_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerEmailonFB();


            }
        });

    }

    void registerEmailonFB()
    {
        String mobile=e3mobile.getText().toString().trim();
        String weight=e1_we.getText().toString();
        String height=e2_hi.getText().toString();

        if (mobile.isEmpty())
        {
            Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if (weight.isEmpty())
        {
            Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT).show();

            return;
        }
        if (height.isEmpty())
        {
            Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT).show();

            return;
        }
        databaseReference.child(mobile).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    Toast.makeText(TakeWeiHigActivity.this, "email already Exists", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    storeDatainFB(mobile,weight,height);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(TakeWeiHigActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
     public void storeDatainFB(String mobile, String weight, String height)
     {
         Map<String, String>userData =new HashMap<>();
        userData.put("Height", height);
        userData.put("Weight", weight);

        databaseReference.child(mobile).setValue(userData).addOnCompleteListener(task ->
        {
            if (task.isSuccessful())
            {
                Toast.makeText(this, "Data Stored", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
     }


}