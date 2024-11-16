package com.example.campusreq.Fragments.Student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.campusreq.R;
import com.example.campusreq.pojo.Student;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentUpdateFragment extends Fragment {

    private EditText editTextFullName, editTextContactNo, editTextRegNumber, editTextSummary,
            editTextKeySkills, editTextTenthPercentage, editTextTenthBoard, editTextTenthSchool,
            editTextTenthCity, editTextTwelfthPercentage, editTextTwelfthBoard, editTextTwelfthSchool,
            editTextTwelfthCity;
    private Button buttonUpdate;

    // Additional EditText fields
    private EditText editTextDiplomaPercentage, editTextDiplomaBoard, editTextDiplomaCollege,
            editTextDiplomaCity, editTextFieldOfInterest, editTextAchievements,
            editTextLeetCodeLink, editTextHackerRankLink, editTextGitHubLink, editTextLinkedInLink;

    private DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_update, container, false);

        editTextFullName = view.findViewById(R.id.stu_Update_fullName);
        editTextContactNo = view.findViewById(R.id.stu_Update_ContactNo);
        editTextRegNumber = view.findViewById(R.id.stu_Update_RegNumber);
        editTextSummary = view.findViewById(R.id.stu_Update_Summary);
        editTextKeySkills = view.findViewById(R.id.stu_Update_KeySkills);
        editTextTenthPercentage = view.findViewById(R.id.stu_Update_tenthPercentage);
        editTextTenthBoard = view.findViewById(R.id.stu_Update_tenthBoard);
        editTextTenthSchool = view.findViewById(R.id.stu_Update_tenthSchool);
        editTextTenthCity = view.findViewById(R.id.stu_Update_tenthCity);
        editTextTwelfthPercentage = view.findViewById(R.id.stu_Update_twelfthPercentage);
        editTextTwelfthBoard = view.findViewById(R.id.stu_Update_twelfthBoard);
        editTextTwelfthSchool = view.findViewById(R.id.stu_Update_twelfthSchool);
        editTextTwelfthCity = view.findViewById(R.id.stu_Update_twelfthCity);
        buttonUpdate = view.findViewById(R.id.stu_UpdateBtn);


        // Initialize additional EditText fields
        editTextDiplomaPercentage = view.findViewById(R.id.stu_Update_diplomaPercentage);
        editTextDiplomaBoard = view.findViewById(R.id.stu_Update_diplomaBoard);
        editTextDiplomaCollege = view.findViewById(R.id.stu_Update_diplomaCollege);
        editTextDiplomaCity = view.findViewById(R.id.stu_Update_diplomaCity);
        editTextFieldOfInterest = view.findViewById(R.id.stu_Update_fieldOfInterest);
        editTextAchievements = view.findViewById(R.id.stu_Update_achievements);
        editTextLeetCodeLink = view.findViewById(R.id.stu_Update_leetCodeLink);
        editTextHackerRankLink = view.findViewById(R.id.stu_Update_HackerRankLink);
        editTextGitHubLink = view.findViewById(R.id.stu_Update_GitHubLink);
        editTextLinkedInLink = view.findViewById(R.id.stu_Update_LinkedInLink);

        databaseReference = FirebaseDatabase.getInstance().getReference("Students");

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        return view;
    }

    private void saveData() {
        // Retrieve data from EditText fields
        String fullName = editTextFullName.getText().toString().trim();
        String contactNo = editTextContactNo.getText().toString().trim();
        String regNumber = editTextRegNumber.getText().toString().trim();
        String summary = editTextSummary.getText().toString().trim();
        String keySkills = editTextKeySkills.getText().toString().trim();
        String tenthPercentage = editTextTenthPercentage.getText().toString().trim();
        String tenthBoard = editTextTenthBoard.getText().toString().trim();
        String tenthSchool = editTextTenthSchool.getText().toString().trim();
        String tenthCity = editTextTenthCity.getText().toString().trim();
        String twelfthPercentage = editTextTwelfthPercentage.getText().toString().trim();
        String twelfthBoard = editTextTwelfthBoard.getText().toString().trim();
        String twelfthSchool = editTextTwelfthSchool.getText().toString().trim();
        String twelfthCity = editTextTwelfthCity.getText().toString().trim();

        // Additional fields
        String diplomaPercentage = editTextDiplomaPercentage.getText().toString().trim();
        String diplomaBoard = editTextDiplomaBoard.getText().toString().trim();
        String diplomaCollege = editTextDiplomaCollege.getText().toString().trim();
        String diplomaCity = editTextDiplomaCity.getText().toString().trim();
        String fieldOfInterest = editTextFieldOfInterest.getText().toString().trim();
        String achievements = editTextAchievements.getText().toString().trim();
        String leetCodeLink = editTextLeetCodeLink.getText().toString().trim();
        String hackerRankLink = editTextHackerRankLink.getText().toString().trim();
        String gitHubLink = editTextGitHubLink.getText().toString().trim();
        String linkedInLink = editTextLinkedInLink.getText().toString().trim();



        // Create a new Student object
        Student student = new Student(fullName, contactNo, regNumber, summary, keySkills,
                tenthPercentage, tenthBoard, tenthSchool, tenthCity, twelfthPercentage,
                twelfthBoard, twelfthSchool, twelfthCity, diplomaPercentage, diplomaBoard,
                diplomaCollege, diplomaCity, fieldOfInterest, achievements, leetCodeLink,
                hackerRankLink, gitHubLink, linkedInLink);

        // Check if the registration number already exists in the database
        databaseReference.child(regNumber).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Registration number exists, update all content based on that regnumber
                    databaseReference.child(regNumber).setValue(student)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    // Show a toast message indicating successful update
                                    Toast.makeText(getContext(), "Update Successful", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // Show a toast message indicating failure, if needed
                                    Toast.makeText(getContext(), "Update Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    // Registration number does not exist, create a new entry
                    databaseReference.child(regNumber).setValue(student)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    // Show a toast message indicating successful creation of new entry
                                    Toast.makeText(getContext(), "New Entry Created", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // Show a toast message indicating failure, if needed
                                    Toast.makeText(getContext(), "Update Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle onCancelled if needed
            }
        });
    }

}