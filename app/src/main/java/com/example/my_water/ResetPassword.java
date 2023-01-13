package com.example.my_water;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {
    private EditText editText;
    private ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);




        editText=findViewById(R.id.emailResetPassword);
        Button button = findViewById(R.id.resetPassword);
        progressBar=findViewById(R.id.progressBar3);
        mAuth=FirebaseAuth.getInstance();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail=editText.getText().toString().trim();

                if(userEmail.isEmpty()){
                    editText.setError("Enter your email!");
                    editText.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                    editText.setError("Enter a valid email address!");
                    editText.requestFocus();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(ResetPassword.this,"Check your email to reset password",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(ResetPassword.this,SignIn.class);
                            startActivity(intent);
                        }
                        else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(ResetPassword.this,"Failed to reset the password!",Toast.LENGTH_LONG).show();
                        }

                    }
                });

            }
        });
    }
}