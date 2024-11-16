package com.example.campusreq.Fragments.Admin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.campusreq.R;
import com.example.campusreq.pojo.JobPost;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminPostJobsFragment extends Fragment {

    private EditText editTextJobId, editTextCompanyName, editTextBatch, editTextCompanyMarket, editTextJobDescription, editTextEmploymentType,
            editTextJobRole, editTextJobLocation, editTextHiringProcess, editTextProbationPeriod,
            editTextSalaryDuringProbation, editTextSalaryAfterProbation, editTextBond, editTextWorkingDaysPerWeek,
            editTextMessageForStudents, editTextTwelfthPercentage, editTextGraduationPercentage, editTextBacklogs;
    private Button buttonPostJob;

    private DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_post_jobs, container, false);

        editTextJobId = view.findViewById(R.id.admin_post_jobId);
        editTextCompanyName = view.findViewById(R.id.admin_post_companyName);
        editTextBatch = view.findViewById(R.id.admin_post_batch);
        editTextCompanyMarket = view.findViewById(R.id.admin_post_companyMarket);
        editTextJobDescription = view.findViewById(R.id.admin_post_jobDescription);
        editTextEmploymentType = view.findViewById(R.id.admin_post_employementType);
        editTextJobRole = view.findViewById(R.id.admin_post_jobRole);
        editTextJobLocation = view.findViewById(R.id.admin_post_job_Location);
        editTextHiringProcess = view.findViewById(R.id.admin_post_hiringProcess);
        editTextProbationPeriod = view.findViewById(R.id.admin_post_probationPeriod);
        editTextSalaryDuringProbation = view.findViewById(R.id.admin_post_salaryduringProbation);
        editTextSalaryAfterProbation = view.findViewById(R.id.admin_post_salaryafterProbation);
        editTextBond = view.findViewById(R.id.admin_post_bond);
        editTextWorkingDaysPerWeek = view.findViewById(R.id.admin_post_workingDaysPerWeek);
        editTextMessageForStudents = view.findViewById(R.id.admin_post_messageForStudents);
        editTextTwelfthPercentage = view.findViewById(R.id.admin_post_12thPercentage);
        editTextGraduationPercentage = view.findViewById(R.id.admin_post_graduationPercentage);
        editTextBacklogs = view.findViewById(R.id.admin_post_backLogs);

        buttonPostJob = view.findViewById(R.id.admin_post_jobsBtn);

        databaseReference = FirebaseDatabase.getInstance().getReference("Jobs");

        buttonPostJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postJob();
            }
        });

        return view;
    }

    private void postJob() {
        String jobId = editTextJobId.getText().toString().trim(); // Assuming editTextJobId is the EditText for job ID
        String companyName = editTextCompanyName.getText().toString().trim();
        String batch = editTextBatch.getText().toString().trim();
        String companyMarket = editTextCompanyMarket.getText().toString().trim();
        String jobDescription = editTextJobDescription.getText().toString().trim();
        String employmentType = editTextEmploymentType.getText().toString().trim();
        String jobRole = editTextJobRole.getText().toString().trim();
        String jobLocation = editTextJobLocation.getText().toString().trim();
        String hiringProcess = editTextHiringProcess.getText().toString().trim();
        String probationPeriod = editTextProbationPeriod.getText().toString().trim();
        String salaryDuringProbation = editTextSalaryDuringProbation.getText().toString().trim();
        String salaryAfterProbation = editTextSalaryAfterProbation.getText().toString().trim();
        String bond = editTextBond.getText().toString().trim();
        String workingDaysPerWeek = editTextWorkingDaysPerWeek.getText().toString().trim();
        String messageForStudents = editTextMessageForStudents.getText().toString().trim();
        String twelfthPercentage = editTextTwelfthPercentage.getText().toString().trim();
        String graduationPercentage = editTextGraduationPercentage.getText().toString().trim();
        String backlogs = editTextBacklogs.getText().toString().trim();

        if (TextUtils.isEmpty(jobId)) {
            Toast.makeText(getContext(), "Please enter Job ID", Toast.LENGTH_SHORT).show();
            return;
        }

        JobPost jobPost = new JobPost(jobId, companyName, batch, companyMarket, jobDescription, employmentType,
                jobRole, jobLocation, hiringProcess, probationPeriod, salaryDuringProbation, salaryAfterProbation,
                bond, workingDaysPerWeek, messageForStudents, twelfthPercentage, graduationPercentage, backlogs);

        // Reference to the Jobs node under the main database reference
        DatabaseReference jobsRef = FirebaseDatabase.getInstance().getReference().child("Jobs").child(jobId);

        jobsRef.setValue(jobPost)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext(), "Job Posted Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "Job Posting Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
