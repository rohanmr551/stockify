package com.example.ds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ds.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize ViewBinding
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Set OnClickListener for Sign-Up button
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input from user
                String email = binding.email.getText().toString().trim();
                String password = binding.password.getText().toString().trim();
                String confirmPassword = binding.retypepassword.getText().toString().trim();

                // Check if any field is empty
                if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
                // Check if passwords match
                else if (!password.equals(confirmPassword)) {
                    Toast.makeText(SignUpActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
                // Proceed with database operations
                else {
                    boolean checkUserEmail = databaseHelper.checkEmail(email);
                    if (checkUserEmail) {
                        Toast.makeText(SignUpActivity.this, "User already exists, please login", Toast.LENGTH_SHORT).show();
                    } else {
                        boolean insert = databaseHelper.insertData(email, password);
                        if (insert) {
                            Toast.makeText(SignUpActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                            // Redirect to MainActivity after successful signup
                            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish(); // Prevents returning to this activity
                        } else {
                            Toast.makeText(SignUpActivity.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        // Set OnClickListener for TextView to redirect to SignInActivity
        binding.textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
                finish(); // Prevents returning to this activity
            }
        });
    }
}
