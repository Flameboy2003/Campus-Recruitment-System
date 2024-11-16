package com.example.campusreq.Fragments.Admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.campusreq.R;
import com.example.campusreq.pojo.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminHomeDetailedViewFragment extends Fragment {

    private TextView fullNameTextView, contactNoTextView, summaryTextView, keySkillsTextView;
    // Add other TextViews for other fields

    public AdminHomeDetailedViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_home_detailed_view, container, false);

        fullNameTextView = view.findViewById(R.id.fullNameTextView);
        contactNoTextView = view.findViewById(R.id.contactNoTextView);
        summaryTextView = view.findViewById(R.id.summaryTextView);
        keySkillsTextView = view.findViewById(R.id.keySkillsTextView);
        // Initialize other TextViews similarly for other fields

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("regNumber")) {
            String regNumber = bundle.getString("regNumber");
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Students").child(regNumber);
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        Student student = dataSnapshot.getValue(Student.class);
                        if (student != null) {
                            fullNameTextView.setText(student.getFullName());
                            contactNoTextView.setText(student.getContactNo());
                            summaryTextView.setText(student.getSummary());
                            keySkillsTextView.setText(student.getKeySkills());
                            // Set other fields similarly
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle onCancelled if needed
                }
            });
        }

        return view;
    }
}
