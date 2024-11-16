package com.example.campusreq;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private EditText mFullName, mEmail, mPassword, mConfirmPass;
    private Button studentRegisterBtn;
    private TextView backToSignIn;
    private ProgressBar progressBar;
    private FirebaseAuth fAuth;

    private boolean passwordShowing = false;
    private boolean conPasswordShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        mConfirmPass = findViewById(R.id.confirmPass);
        studentRegisterBtn = findViewById(R.id.studentRegisterBtn);
        progressBar = findViewById(R.id.progressBar);

        backToSignIn= findViewById(R.id.studentSign);


        backToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        final ImageView passwordIcon = findViewById(R.id.passwordEye);
        final ImageView conPasswordIcon = findViewById(R.id.conpasswordEye);

        fAuth = FirebaseAuth.getInstance();

        passwordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility(mPassword, passwordIcon);
            }
        });

        conPasswordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility(mConfirmPass, conPasswordIcon);
            }
        });

        studentRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }



    private void togglePasswordVisibility(EditText editText, ImageView imageView) {
        if (passwordShowing) {
            passwordShowing = false;
            editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            imageView.setImageResource(R.drawable.show);
        } else {
            passwordShowing = true;
            editText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            imageView.setImageResource(R.drawable.hide);
        }
        editText.setSelection(editText.length());
    }

    private void registerUser() {
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String fullName = mFullName.getText().toString().trim();
        String confirmPass = mConfirmPass.getText().toString().trim();

        if (TextUtils.isEmpty(fullName)) {
            mFullName.setError("Full Name is Required");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            mEmail.setError("Email is Required");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            mPassword.setError("Password is Required");
            return;
        }
        if (password.length() < 6) {
            mPassword.setError("Password must be at least 6 characters");
            return;
        }
        if (!password.equals(confirmPass)) {
            mConfirmPass.setError("Passwords do not match");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        // Register the user
        fAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "User created successfully", Toast.LENGTH_SHORT).show();
                            sendEmailVerification(fAuth.getCurrentUser());
                        } else {
                            Toast.makeText(RegisterActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void sendEmailVerification(FirebaseUser user) {
        user.sendEmailVerification()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(RegisterActivity.this, "Verification email sent", Toast.LENGTH_SHORT).show();
                        // After sending verification email, redirect user to login page
                        startActivity(new Intent(RegisterActivity.this, FirstActivity.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "Failed to send verification email", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
