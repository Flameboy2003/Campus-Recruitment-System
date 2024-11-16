package com.example.campusreq.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusreq.Fragments.Student.StudentApplyFragment;
import com.example.campusreq.R;
import com.example.campusreq.pojo.JobPost;

import java.util.List;


public class JobPostAdapter extends RecyclerView.Adapter<JobPostAdapter.ViewHolder> {
    private List<JobPost> jobList;
    private OnItemClickListener listener;

    public JobPostAdapter(List<JobPost> jobList) {
        this.jobList = jobList;
    }

    // Interface to handle item click events
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Method to register the click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_job_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        JobPost jobPost = jobList.get(position);
        holder.bind(jobPost);

        // Set click listener for the item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewJobId;
        private TextView textViewCompanyName;
        // Other TextViews for other job details...

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewJobId = itemView.findViewById(R.id.textViewJobId);
            textViewCompanyName = itemView.findViewById(R.id.textViewCompanyName);
            // Initialize other TextViews...
        }

        public void bind(JobPost jobPost) {
            textViewJobId.setText(jobPost.getJobId());
            textViewCompanyName.setText(jobPost.getCompanyName());
            // Bind other job details...
        }
    }
}
