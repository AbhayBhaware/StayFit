package com.example.stayfit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileFragment extends Fragment {


    LinearLayout l1;

    TextView t1User, t2Weight, t3Hight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);

        t1User=v.findViewById(R.id.userNM);
        t2Weight=v.findViewById(R.id.IDweight);
        t3Hight=v.findViewById(R.id.IDHight);

        SharedPreferences sharedPreferences= requireActivity().getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","Guest");
        t1User.setText(username);


        SharedPreferences sharedPreferences1=requireActivity().getSharedPreferences("Myweight",Context.MODE_PRIVATE);
        String weight=sharedPreferences1.getString("weight","60");
        t2Weight.setText(weight);


        SharedPreferences sharedPreferences2=requireActivity().getSharedPreferences("Myhight",Context.MODE_PRIVATE);
        String hight=sharedPreferences2.getString("hight","170");
        t3Hight.setText(hight);

        l1=v.findViewById(R.id.shareLAY);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareText("Check Out My Application StayFit");
            }
        });




        return v;
    }

    public void shareText(String txt)
    {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, txt);
        startActivity(Intent.createChooser(i, "Share Via"));
    }
}