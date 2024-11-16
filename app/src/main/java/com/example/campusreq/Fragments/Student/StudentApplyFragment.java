package com.example.campusreq.Fragments.Student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.campusreq.Adapters.JobPostAdapter;
import com.example.campusreq.R;
import com.example.campusreq.pojo.JobPost;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentApplyFragment extends Fragment implements JobPostAdapter.OnItemClickListener {

    private RecyclerView recyclerViewJobs;
    private List<JobPost> jobList;
    private JobPostAdapter adapter;
    private ProgressBar progressBar;
    private DatabaseReference jobsRef;
    private ValueEventListener valueEventListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_apply, container, false);

        recyclerViewJobs = view.findViewById(R.id.recyclerViewJobs);
        recyclerViewJobs.setLayoutManager(new LinearLayoutManager(getContext()));

        jobList = new ArrayList<>();
        adapter = new JobPostAdapter(jobList);
        adapter.setOnItemClickListener(this); // Set the click listener
        recyclerViewJobs.setAdapter(adapter);

        progressBar = view.findViewById(R.id.progressBar); // Initialize ProgressBar

        // Reference to the Jobs node in Firebase Realtime Database
        jobsRef = FirebaseDatabase.getInstance().getReference().child("Jobs");
        fetchJobPosts();

        return view;
    }

    private void fetchJobPosts() {
        progressBar.setVisibility(View.VISIBLE); // Show ProgressBar before fetching data
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                jobList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    JobPost jobPost = postSnapshot.getValue(JobPost.class);
                    jobList.add(jobPost);
                }
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE); // Hide ProgressBar after data is fetched
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressBar.setVisibility(View.GONE); // Hide ProgressBar in case of error
                Toast.makeText(getContext(), "Failed to retrieve job posts: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };
        jobsRef.addValueEventListener(valueEventListener);
    }

    // Handle item click events
    @Override
    public void onItemClick(int position) {
        // Retrieve the selected job
        JobPost selectedJob = jobList.get(position);

        // Pass the selected job details to StudentDetailedApplyFragment
        com.example.campusreq.Fragments.Student.StudentDetailedApplyFragment detailedApplyFragment = new StudentDetailedApplyFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("selectedJob", (Serializable) selectedJob);
        detailedApplyFragment.setArguments(bundle);

        // Replace the current fragment with StudentDetailedApplyFragment
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, detailedApplyFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Remove ValueEventListener to prevent memory leaks
        if (jobsRef != null && valueEventListener != null) {
            jobsRef.removeEventListener(valueEventListener);
        }
    }
}
