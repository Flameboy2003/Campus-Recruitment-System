package com.example.campusreq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.campusreq.Fragments.Admin.AdminHomeFragment;
import com.example.campusreq.Fragments.Admin.AdminMainActivity;
import com.example.campusreq.Fragments.Student.StudentMainActivity;
import com.example.campusreq.pojo.Student;


public class Admin_Student_verify_Activity extends AppCompatActivity {

        private EditText adminCodeEditText;
        private Button verifyButton;
        private TextView goToStudent;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_admin_student_verify);

            adminCodeEditText = findViewById(R.id.adminCode);
            verifyButton = findViewById(R.id.VerifyAdminOrStudentBtn);
            goToStudent=findViewById(R.id.goToStudent);

            verifyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    verifyAdminCode();
                }
            });

            goToStudent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Admin_Student_verify_Activity.this, StudentMainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });
        }



        private void verifyAdminCode() {
            String adminCode = adminCodeEditText.getText().toString().trim();
            if (adminCode.equals("AU2025")) {
                // Admin code is correct, navigate to AdminHomeFragment
                // Example:
                Intent intent = new Intent(Admin_Student_verify_Activity.this, AdminMainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                // Admin code is incorrect, show toast message
                Toast.makeText(this, "Please enter a valid Admin code", Toast.LENGTH_SHORT).show();
            }
        }


    }

