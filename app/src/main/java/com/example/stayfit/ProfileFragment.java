package com.example.stayfit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

import java.security.PrivateKey;
import java.util.PrimitiveIterator;

public class ProfileFragment extends Fragment {


    LinearLayout l1, l2, l3;

    TextView t1User, t2Weight, t3Hight, logout;

    FloatingActionButton fab;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);

        fab=v.findViewById(R.id.FloatingBTN);

        t1User=v.findViewById(R.id.userNM);
        t2Weight=v.findViewById(R.id.IDweight);
        t3Hight=v.findViewById(R.id.IDHight);

        SharedPreferences sharedPreferences= requireActivity().getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","Guest");
        t1User.setText(username);


        SharedPreferences sharedPreferences1=requireActivity().getSharedPreferences("Myweight",Context.MODE_PRIVATE);
        String weight=sharedPreferences1.getString("weight","60");
        t2Weight.setText(weight);


        SharedPreferences sharedPreferences2=requireActivity().getSharedPreferences("Myhight",Context.MODE_PRIVATE);
        String hight=sharedPreferences2.getString("hight","170");
        t3Hight.setText(hight);

        l1=v.findViewById(R.id.shareLAY);
        l2=v.findViewById(R.id.rateusLAY);
        l3=v.findViewById(R.id.feedbackLAY);
        logout=v.findViewById(R.id.logoutBTN);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareText("Check Out My Application StayFit");
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 showRatingDialog();
            }
        });

        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment feedFrag=new FeedbackFragment();
                FragmentManager fragmentManager=getParentFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.framelayout,feedFrag);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext(), "Feedback Page", Toast.LENGTH_SHORT).show();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent i=new Intent(requireActivity(),LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                requireActivity().finish();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(requireActivity(),TakeWeiHigActivity.class);
                startActivity(i);
                //requireActivity().finish();
            }
        });



        return v;
    }



    public void shareText(String txt)
    {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, txt);
        startActivity(Intent.createChooser(i, "Share Via"));
    }

    public void showRatingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Rate Our App");

        final RatingBar ratingBar = new RatingBar(requireContext());
        ratingBar.setNumStars(5);
        ratingBar.setStepSize(0.5f);
        ratingBar.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        builder.setView(ratingBar);

        builder.setPositiveButton("Submit", (dialog, which) -> {
            float rating = ratingBar.getRating();
            Toast.makeText(getContext(), "Rating Done", Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        builder.show();
    }


}