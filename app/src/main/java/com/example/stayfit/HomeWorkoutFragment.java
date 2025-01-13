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


public class HomeWorkoutFragment extends Fragment {


    ImageView i1_bodyweight, i2_pushup, i3_plank, i4_bicycle, i5_glute, i6_sideleg, i7_wallsit, i8_stepups;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home_workout, container, false);

        i1_bodyweight=v.findViewById(R.id.bodyweightImg);
        i2_pushup=v.findViewById(R.id.pushupImg);
        i3_plank=v.findViewById(R.id.plankImg);
        i4_bicycle=v.findViewById(R.id.bicycleImg);
        i5_glute=v.findViewById(R.id.gluteImg);
        i6_sideleg=v.findViewById(R.id.sidelegImg);
        i7_wallsit=v.findViewById(R.id.wallsitImg);
        i8_stepups=v.findViewById(R.id.stepupsImgg);





        i1_bodyweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment homeSteps=new BodyweightFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,homeSteps);
                transaction.addToBackStack(null);
                transaction.commit();

                
            }
        });

        i2_pushup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment homeSteps =new PushupsFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,homeSteps);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        i3_plank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment homeSteps =new PlankFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,homeSteps);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        i4_bicycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment homeSteps=new BicycleFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,homeSteps);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        i5_glute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment homeSteps=new GluteFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,homeSteps);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        i6_sideleg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment homeSteps =new SidelegraisesFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,homeSteps);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        i7_wallsit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment homeSteps =new WallsitFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,homeSteps);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        i8_stepups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment homeSteps =new StepupssFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,homeSteps);
                transaction.addToBackStack(null);
                transaction.commit();

                
            }
        });

        return v;
    }
}