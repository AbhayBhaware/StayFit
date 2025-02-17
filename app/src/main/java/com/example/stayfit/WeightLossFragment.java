package com.example.stayfit;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

public class WeightLossFragment extends Fragment {


    Button b1_play;
    VideoView v1_vid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_weight_loss, container, false);

        b1_play=v.findViewById(R.id.playBTN);
        v1_vid=v.findViewById(R.id.weightlossVID);

        Uri vidUri=Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.weightlossvid);
        v1_vid.setVideoURI(vidUri);

        b1_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v1_vid.isPlaying())
                {
                    v1_vid.pause();
                    b1_play.setText("PLAY");
                }
                else {
                    v1_vid.start();
                    b1_play.setText("PAUSE");
                }
            }
        });


        return v;
    }
}