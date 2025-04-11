package com.example.stayfit;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

public class BalancedFragment extends Fragment {


    Button b1play;
    VideoView v1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_balanced, container, false);

        b1play=v.findViewById(R.id.playBTN3);
        v1=v.findViewById(R.id.balancedVID);

        Uri vidUri=Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.balanced);
        v1.setVideoURI(vidUri);

        b1play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v1.isPlaying())
                {
                    v1.pause();
                    b1play.setText("PLAY");
                }
                else {
                    v1.start();
                    b1play.setText("PAUSE");
                }
            }
        });

        return v;
    }
}