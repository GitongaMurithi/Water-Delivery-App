package com.example.my_water;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;


public class SignUp extends AppCompatActivity {
    private EditText userName;
    private EditText password;
    private EditText mobileNo;
    private EditText UserEmail;
    private ProgressBar progressBar;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userName = findViewById(R.id.ueserName);
        password = findViewById(R.id.Password);
        mobileNo = findViewById(R.id.MobileNo);
        UserEmail = findViewById(R.id.email);
        progressBar = findViewById(R.id.progressBar);
        Button myButton = findViewById(R.id.button);

        mAuth = FirebaseAuth.getInstance();


        myButton.setOnClickListener(view -> {

            String userData = userName.getText().toString().trim();
            String userPassword = password.getText().toString().trim();
            String userPhone = mobileNo.getText().toString().trim();
            String userMail = UserEmail.getText().toString().trim();

            if (userData.isEmpty()) {
                userName.setError("Please enter user name!");
                userName.requestFocus();
                return;
            }
            if (userPassword.isEmpty() || userPassword.length() < 6) {
                password.setError("Please enter user password containing at least 6 characters!");
                password.requestFocus();
                return;
            }
            if (userPhone.isEmpty()) {
                mobileNo.setError("Please enter user phone number!");
                mobileNo.requestFocus();
                return;
            }
            if (userMail.isEmpty()) {
                UserEmail.setError("Please enter user email!");
                UserEmail.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(userMail).matches()) {
                UserEmail.setError("Please enter a valid email address!");
                UserEmail.requestFocus();
                return;
            }
            progressBar.setVisibility(View.VISIBLE);

            mAuth.createUserWithEmailAndPassword(userMail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {

                        User user = new User(userData, userPassword, userPhone, userMail);

                        FirebaseDatabase.getInstance().getReference("Users").child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).setValue(user)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {

                                            Toast.makeText(SignUp.this, "Registered successfully", Toast.LENGTH_LONG).show();
                                            progressBar.setVisibility(View.GONE);
                                        } else {
                                            Toast.makeText(SignUp.this, "Failed to register,check your credentials or network!", Toast.LENGTH_LONG).show();
                                            progressBar.setVisibility(View.GONE);
                                        }
                                    }

                                });
                    } else {
                        Toast.makeText(SignUp.this, "Failed to register,check your credentials or network!", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }

                }


            });
        });

    }
}