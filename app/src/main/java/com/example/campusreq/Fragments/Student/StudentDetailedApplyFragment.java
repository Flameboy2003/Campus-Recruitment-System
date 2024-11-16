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
import com.example.campusreq.pojo.JobPost;

public class StudentDetailedApplyFragment extends Fragment {
    private TextView textViewJobId;
    private TextView textViewCompanyName;
    private TextView textViewJobDescription;
    private TextView textViewBatch;
    private TextView textViewJobRole;
    private TextView textViewJobLocation;
    private TextView textViewProbationPeriod;
    private TextView textViewSalaryDuringProbationPeriod;
    private TextView textViewSalaryAfterProbationPeriod;
    private TextView textViewBond;
    private TextView textViewMessageStudent;
    private TextView textView12thPercentage;
    private TextView textViewGraduation;
    private TextView textViewHiringProcess;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_detailed_apply, container, false);

        textViewJobId = view.findViewById(R.id.textViewJobId);
        textViewCompanyName = view.findViewById(R.id.textViewCompanyName);
        textViewJobDescription =view.findViewById(R.id.textViewJobDescription);
        textViewBatch=view.findViewById(R.id.textViewBatch);
        textViewJobRole = view.findViewById(R.id.textViewJobRole);
        textViewJobLocation = view.findViewById(R.id.textViewJobLocation);
        textViewProbationPeriod = view.findViewById(R.id.textViewProbationPeriod);
        textViewSalaryDuringProbationPeriod = view.findViewById(R.id.textViewSalaryDuringProbationPeriod);
        textViewSalaryAfterProbationPeriod = view.findViewById(R.id.textViewSalaryAfterProbationPeriod);
        textViewBond = view.findViewById(R.id.textViewBond);
        textViewMessageStudent = view.findViewById(R.id.textViewMessageStudent);
        textView12thPercentage = view.findViewById(R.id.textView12thPercentage);
        textViewGraduation = view.findViewById(R.id.textViewGraduation);
        textViewHiringProcess = view.findViewById(R.id.textViewHiringProcess);

        // Initialize other TextViews...

        // Retrieve job details from arguments
        Bundle bundle = getArguments();
        if (bundle != null) {
            JobPost selectedJob = (JobPost) bundle.getSerializable("selectedJob");
            if (selectedJob != null) {
                textViewJobId.setText(selectedJob.getJobId());
                textViewCompanyName.setText(selectedJob.getCompanyName());
                textViewJobDescription.setText(selectedJob.getJobDescription());
                textViewBatch.setText(selectedJob.getBatch());
                textViewJobRole.setText(selectedJob.getJobRole());
                textViewJobLocation.setText(selectedJob.getJobLocation());
                textViewProbationPeriod.setText(selectedJob.getProbationPeriod());
                textViewSalaryDuringProbationPeriod.setText(selectedJob.getSalaryDuringProbation());
                textViewSalaryAfterProbationPeriod.setText(selectedJob.getSalaryAfterProbation());
                textViewBond.setText(selectedJob.getBond());
                textViewMessageStudent.setText(selectedJob.getMessageForStudents());
                textView12thPercentage.setText(selectedJob.getTwelfthPercentage());
                textViewGraduation.setText(selectedJob.getGraduationPercentage());
                textViewHiringProcess.setText(selectedJob.getHiringProcess());
                // Set other job details as needed
            }
        }

        return view;
    }
}
