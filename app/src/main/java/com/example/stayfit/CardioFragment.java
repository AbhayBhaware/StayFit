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


public class CardioFragment extends Fragment {

    ImageView i1_walking, i2_jogging, i3_highknees, i4_jumpingjacks, i5_jumprope, i6_mountain, i7_skaters, i8_step;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_cardio, container, false);

        i1_walking=v.findViewById(R.id.walkingImg);
        i2_jogging=v.findViewById(R.id.jogginginImg);
        i3_highknees=v.findViewById(R.id.highkneesImg);
        i4_jumpingjacks=v.findViewById(R.id.jumpingjacksImg);
        i5_jumprope=v.findViewById(R.id.jumpropeImg);
        i6_mountain=v.findViewById(R.id.mountainImg);
        i7_skaters=v.findViewById(R.id.skatersImg);
        i8_step=v.findViewById(R.id.stepImg);




        i1_walking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment cardioSteps =new WalkingFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,cardioSteps);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Walking", Toast.LENGTH_SHORT).show();
            }
        });

        i2_jogging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment cardioSteps =new JogginginplaceFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,cardioSteps);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Jogging in Place", Toast.LENGTH_SHORT).show();
            }
        });

        i3_highknees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment cardioSteps=new HighKneesFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,cardioSteps);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "High Knees", Toast.LENGTH_SHORT).show();
            }
        });

        i4_jumpingjacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment cardioSteps=new JumpingjacksFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,cardioSteps);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Jumping Jacks", Toast.LENGTH_SHORT).show();
            }
        });

        i5_jumprope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment cardioSteps =new JumpropeFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,cardioSteps);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Jump Rope", Toast.LENGTH_SHORT).show();
            }
        });

        i6_mountain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment cardioSteps=new MountainclimbFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,cardioSteps);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Mountain Climbers", Toast.LENGTH_SHORT).show();
            }
        });

        i7_skaters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment cardioSteps=new SkatersFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,cardioSteps);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Skaters", Toast.LENGTH_SHORT).show();
            }
        });

        i8_step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment cardioSteps=new StepFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,cardioSteps);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Step Ups", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}