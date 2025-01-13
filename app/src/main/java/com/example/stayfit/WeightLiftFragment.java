package com.example.stayfit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class WeightLiftFragment extends Fragment {

    ImageView i1_goblet, i2_deadlift, i3_bicepcurls, i4_shoulderraises, i5_tricepdips, i6_stepups, i7_benchpress, i8_bentoverrow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_weight_lift, container, false);

        i1_goblet=v.findViewById(R.id.gobletImg);
        i2_deadlift=v.findViewById(R.id.DeadliftImg);
        i3_bicepcurls=v.findViewById(R.id.bicepcurlsImg);
        i4_shoulderraises=v.findViewById(R.id.shoulderraisesImg);
        i5_tricepdips=v.findViewById(R.id.tricepImg);
        i6_stepups=v.findViewById(R.id.stepupsImg);
        i7_benchpress=v.findViewById(R.id.benchpressImg);
        i8_bentoverrow=v.findViewById(R.id.bentoverImg);

        i1_goblet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment weightStepFrag =new GobletSquatsFragment();
                FragmentManager fragmentManager =getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,weightStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        i2_deadlift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment weightStepFrag=new DeadliftFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,weightStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        i3_bicepcurls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment weightStepFrag=new BicepCurlsFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,weightStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        i4_shoulderraises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment weightStepFrag =new ShoulderraisesFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,weightStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        i5_tricepdips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment weightStepFrag=new TricepdipsFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,weightStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        i6_stepups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment weightStepFrag=new StepupsFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,weightStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        i7_benchpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment weightStepFrag=new BenchpressFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,weightStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        i8_bentoverrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment weightStepFrag =new BentoverrowsFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,weightStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        return v;
    }
}