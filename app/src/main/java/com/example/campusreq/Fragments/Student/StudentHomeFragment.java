package com.example.campusreq.Fragments.Student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.campusreq.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentHomeFragment extends Fragment {

    private TextView totalJobsTextView;
    private DatabaseReference jobsReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_home, container, false);

        totalJobsTextView = view.findViewById(R.id.total_jobs_text_view);

        // Get a reference to the Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        // Reference to the node where your jobs are stored
        jobsReference = FirebaseDatabase.getInstance().getReference().child("Jobs");



        // Attach a listener to count the number of jobs
        jobsReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get the number of child nodes (jobs)
                long totalJobs = dataSnapshot.getChildrenCount();
                // Display the total number of jobs
                totalJobsTextView.setText("Total Jobs: " + totalJobs);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any errors
            }
        });

        return view;
    }
}
