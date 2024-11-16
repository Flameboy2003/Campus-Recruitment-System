package com.example.campusreq.Fragments.Admin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.List;

public class AdminViewStudentsFragment extends Fragment {

    private DatabaseReference databaseReference;
    private List<String> regNumbers;
    private ListView listViewStudents;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_view_students, container, false);

        listViewStudents = view.findViewById(R.id.list_view_students);

        databaseReference = FirebaseDatabase.getInstance().getReference("Students");
        regNumbers = new ArrayList<>();

        fetchData();

        return view;
    }

    private void fetchData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                regNumbers.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    regNumbers.add(snapshot.getKey()); // Add only registration numbers
                }
                displayRegNumbers();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle onCancelled if needed
            }
        });
    }

    private void displayRegNumbers() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, regNumbers);
        listViewStudents.setAdapter(adapter);

        listViewStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String regNumber = regNumbers.get(position);
                displayStudentDetails(regNumber);
            }
        });
    }

    private void displayStudentDetails(String regNumber) {
        databaseReference.child(regNumber).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Student student = dataSnapshot.getValue(Student.class);
                    if (student != null) {
                        // Display student details in a unique UI
                        showStudentDetailsDialog(regNumber, student); // Pass regNumber here
                    }
                } else {
                    // Handle case when data for the registration number does not exist
                    Toast.makeText(getContext(), "No data found for registration number " + regNumber, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle onCancelled if needed
            }
        });
    }

    private void showStudentDetailsDialog(String regNumber, Student student) { // Add regNumber parameter here
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Student Details")
                .setMessage("Name: " + student.getFullName() + "\n" +
                        "Contact No: " + student.getContactNo() + "\n" +
                        "Summary: " + student.getSummary() + "\n" +
                        "Key Skills: " + student.getKeySkills() + "\n" +
                        "10th Percentage: " + student.getTenthPercentage() + "\n" +
                        "10th Board: " + student.getTenthBoard() + "\n" +
                        "10th School: " + student.getTenthSchool() + "\n" +
                        "10th City: " + student.getTenthCity() + "\n" +
                        "12th Percentage: " + student.getTwelfthPercentage() + "\n" +
                        "12th Board: " + student.getTwelfthBoard() + "\n" +
                        "12th School: " + student.getTwelfthSchool() + "\n" +
                        "12th City: " + student.getTwelfthCity())
                .setPositiveButton("OK", null)
                .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteStudent(regNumber); // Use regNumber here
                    }
                })
                .show();
    }

    private void deleteStudent(String regNumber) {
        databaseReference.child(regNumber).removeValue()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext(), "Student deleted successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "Failed to delete student: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
