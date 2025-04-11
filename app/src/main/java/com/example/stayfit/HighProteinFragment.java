package com.example.stayfit;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

public class HighProteinFragment extends Fragment {

    Button b1BTN;
    VideoView v1VID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_high_protein, container, false);

        b1BTN=v.findViewById(R.id.playBTN4);
        v1VID=v.findViewById(R.id.highprotienVID);
        Uri vidUri=Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.highprotein);
        v1VID.setVideoURI(vidUri);

        b1BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v1VID.isPlaying())
                {
                    v1VID.pause();
                    b1BTN.setText("PLAY");
                }
                else {
                    v1VID.start();
                    b1BTN.setText("PAUSE");
                }
            }
        });

        return v;
    }
}