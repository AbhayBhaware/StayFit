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


public class DietFragment extends Fragment {

    ImageView i1_weightloss, i2_musclegain, i3_balanced, i4_highprotein;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_diet, container, false);

        i1_weightloss=v.findViewById(R.id.weightlossimg);
        i2_musclegain=v.findViewById(R.id.musclegainImg);
        i3_balanced=v.findViewById(R.id.balanceddietimg);
        i4_highprotein=v.findViewById(R.id.highprotienimg);

        i1_weightloss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment weightlossFrag=new WeightLossFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,weightlossFrag);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Weight Loss Diet", Toast.LENGTH_SHORT).show();
            }
        });

        i2_musclegain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment musclegainFrag=new MuscleGainFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,musclegainFrag);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Muscle Gain Diet", Toast.LENGTH_SHORT).show();
            }
        });


        i3_balanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment balancedFrag=new BalancedFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,balancedFrag);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Balanced Diet", Toast.LENGTH_SHORT).show();
            }
        });


        i4_highprotein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment highproFrag=new HighProteinFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,highproFrag);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "High Protein Diet", Toast.LENGTH_SHORT).show();
            }
        });



        return v;
    }
}