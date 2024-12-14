package com.example.stayfit;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class HomeFragment extends Fragment {

    TextView t1;

    ImageView i1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_home, container, false);

        t1=v.findViewById(R.id.yogatext);
        i1=v.findViewById(R.id.yogaimg);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment yogaFragment=new YogaFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,yogaFragment);
                transaction.addToBackStack(null);
                transaction.commit();


                Toast.makeText(getContext(), "Yoga Page", Toast.LENGTH_SHORT).show();
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment yogafragment=new YogaFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,yogafragment);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Yoga Page", Toast.LENGTH_SHORT).show();
            }
        });

        return  v;
    }
}