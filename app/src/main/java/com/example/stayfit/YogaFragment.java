package com.example.stayfit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class YogaFragment extends Fragment {

    ImageView i1_vru, i2_bhu, i3_setu, i4_virabhadra2, i5_bala, i6_adhomukha, i7_tadasana, i8_virabhadra1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_yoga, container, false);

        i1_vru=v.findViewById(R.id.vruImg);
        i2_bhu=v.findViewById(R.id.bhuImg);
        i3_setu=v.findViewById(R.id.setuImg);
        i4_virabhadra2=v.findViewById(R.id.vira2Img);
        i5_bala=v.findViewById(R.id.balaImg);
        i6_adhomukha=v.findViewById(R.id.adhoImg);
        i7_tadasana=v.findViewById(R.id.tadaImg);
        i8_virabhadra1=v.findViewById(R.id.vira1Img);

        i1_vru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment yogaStepFrag = new YogaStepsFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,yogaStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Vrukshasana", Toast.LENGTH_SHORT).show();
            }
        });

        i2_bhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment yogaStepFrag=new BhujangaFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,yogaStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Bhujangasana", Toast.LENGTH_SHORT).show();
            }
        });

        i3_setu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment yogaStepFrag =new SetubandhaFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,yogaStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Setu Bandhasana", Toast.LENGTH_SHORT).show();
            }
        });

        i4_virabhadra2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment yogaStepFrag=new Virabhadra2Fragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,yogaStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Virabhadrasana 2", Toast.LENGTH_SHORT).show();
            }
        });

        i5_bala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment yogaStepFrag=new BalasanaFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,yogaStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Balasana", Toast.LENGTH_SHORT).show();
            }
        });

        i6_adhomukha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment yogaStepFrag=new AdhomukhaFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,yogaStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Adho Mukhasana", Toast.LENGTH_SHORT).show();
            }
        });

        i7_tadasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment yogaStepFrag =new TadasanaFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,yogaStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Tadasana", Toast.LENGTH_SHORT).show();
            }
        });

        i8_virabhadra1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment yogaStepFrag=new Virabhadra1Fragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,yogaStepFrag);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Virabhadrasana 1", Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }
}