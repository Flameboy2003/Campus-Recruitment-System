package com.example.campusreq.Adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campusreq.Fragments.Admin.AdminHomeDetailedViewFragment;
import com.example.campusreq.R;
import com.example.campusreq.pojo.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_home_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.bind(student);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView fullNameTextView;
        TextView regNumberTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fullNameTextView = itemView.findViewById(R.id.AdminHomeTextStudentName);
            regNumberTextView = itemView.findViewById(R.id.AdminHomeTextRegNumberName);
            itemView.setOnClickListener(this);
        }

        public void bind(Student student) {
            fullNameTextView.setText(student.getFullName());
            regNumberTextView.setText(student.getRegNumber());
        }

        @Override
        public void onClick(View v) {
            // Handle item click, navigate to the next fragment
            String regNumber = regNumberTextView.getText().toString();
            Fragment fragment = new AdminHomeDetailedViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("regNumber", regNumber);
            fragment.setArguments(bundle);
            FragmentTransaction transaction = ((FragmentActivity) v.getContext()).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }}
