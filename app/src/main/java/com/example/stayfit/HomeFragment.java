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

    TextView t1, t2_weightlift, t3_cardio;

    ImageView i1, i2_weightI, i3_cardioI;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_home, container, false);

        t1=v.findViewById(R.id.yogatext);
        i1=v.findViewById(R.id.yogaimg);
        t2_weightlift=v.findViewById(R.id.weightliftTxt);
        i2_weightI=v.findViewById(R.id.weightImg);
        t3_cardio=v.findViewById(R.id.cardiotxt);
        i3_cardioI=v.findViewById(R.id.cardioimg);

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

        t2_weightlift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment weighfragment=new WeightLiftFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,weighfragment);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Weight Lifting Page", Toast.LENGTH_SHORT).show();

            }
        });

        i2_weightI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment weiFragment=new WeightLiftFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,weiFragment);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Weight Lifting Page", Toast.LENGTH_SHORT).show();
            }
        });

        t3_cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment carFragment=new CardioFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,carFragment);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Cardio Page", Toast.LENGTH_SHORT).show();
            }
        });

        i3_cardioI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment cardFragment=new CardioFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,cardFragment);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Cardio Page", Toast.LENGTH_SHORT).show();
            }
        });

        return  v;
    }
}