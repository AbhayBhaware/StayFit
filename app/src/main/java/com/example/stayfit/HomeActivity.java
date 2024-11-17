package com.example.stayfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment fragment=new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();

        bottomNavigationView=findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.home);
                {
                    fragment=new HomeFragment();
                }
                if (item.getItemId()==R.id.workout)
                {
                    fragment =new WorkoutFragment();
                }
                if (item.getItemId()==R.id.progress)
                {
                    fragment=new ProgressFragment();
                }
                if (item.getItemId()==R.id.profilee)
                {
                    fragment=new ProfileFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();

                return true;
            }
        });
    }
}