package com.example.stayfit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    LinearLayout l1, l2, l3;
    TextView t1User, t2Weight, t3Hight, logout;
    FloatingActionButton fab;

    DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        // Bind Views
        fab = v.findViewById(R.id.FloatingBTN);
        t1User = v.findViewById(R.id.userNM);
        t2Weight = v.findViewById(R.id.IDweight);
        t3Hight = v.findViewById(R.id.IDHight);
        l1 = v.findViewById(R.id.shareLAY);
        l2 = v.findViewById(R.id.rateusLAY);
        l3 = v.findViewById(R.id.feedbackLAY);
        logout = v.findViewById(R.id.logoutBTN);

        // Firebase DB reference
        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        // Retrieve mobile number from SharedPreferences
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String userKey = sharedPreferences.getString("mobile", "");

        if (!userKey.isEmpty()) {
            databaseReference.child(userKey).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String weight = snapshot.child("Weight").getValue(String.class);
                        String height = snapshot.child("Height").getValue(String.class);
                        String username=snapshot.child("Username").getValue(String.class);

                        t2Weight.setText(weight);
                        t3Hight.setText(height);
                        t1User.setText(username);
                    } else {
                        Toast.makeText(getContext(), "No Data Found For This User", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getContext(), "Database Error", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(getContext(), "Mobile number not found in SharedPreferences", Toast.LENGTH_SHORT).show();
        }

        // Share App
        l1.setOnClickListener(v1 -> shareText("Check Out My Application StayFit"));

        // Rate App
        l2.setOnClickListener(v12 -> showRatingDialog());

        // Feedback
        l3.setOnClickListener(v13 -> {
            Fragment feedFrag = new FeedbackFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.framelayout, feedFrag);
            transaction.addToBackStack(null);
            transaction.commit();

            Toast.makeText(getContext(), "Feedback Page", Toast.LENGTH_SHORT).show();
        });

        // Logout
        logout.setOnClickListener(v14 -> {
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(requireActivity(), LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            requireActivity().finish();
        });

        // FAB → Update Weight/Height
        fab.setOnClickListener(v15 -> {
            Intent i = new Intent(requireActivity(), TakeWeiHigActivity.class);
            startActivity(i);
        });

        return v;
    }

    // Share message
    public void shareText(String txt) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, txt);
        startActivity(Intent.createChooser(i, "Share Via"));
    }

    // Show rating dialog
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
            Toast.makeText(getContext(), "Thanks for rating: " + rating, Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        builder.show();
    }
}
