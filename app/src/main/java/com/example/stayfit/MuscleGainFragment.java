package com.example.stayfit;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

public class MuscleGainFragment extends Fragment {


    Button pauseBTN;
    VideoView v1Vid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_muscle_gain, container, false);

        pauseBTN=v.findViewById(R.id.playBTN2);
        v1Vid=v.findViewById(R.id.musclegainVID);

        Uri vidUri=Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.musclegainvid);
        v1Vid.setVideoURI(vidUri);

        pauseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v1Vid.isPlaying())
                {
                    v1Vid.pause();
                    pauseBTN.setText("PLAY");
                }
                else {
                    v1Vid.start();
                    pauseBTN.setText("PAUSE");
                }
            }
        });


        return v;
    }
}