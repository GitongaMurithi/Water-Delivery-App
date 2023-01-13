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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignIn extends AppCompatActivity {

    private EditText editTextEmail,editTextPassword;
    private ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editTextEmail=findViewById(R.id.signInEmail);
        editTextPassword=findViewById(R.id.signInPassword);

        TextView textViewForgotPassword = findViewById(R.id.forgotPassword);
        TextView textViewRegister = findViewById(R.id.registerSignIn);

        Button buttonLogin = findViewById(R.id.loginBtn);
        progressBar=findViewById(R.id.progressBar2);
        mAuth=FirebaseAuth.getInstance();

        textViewForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignIn.this,ResetPassword.class);
                startActivity(intent);


            }
        });

        textViewRegister.setOnClickListener(view -> {
            Intent intent=new Intent(SignIn.this,SignUp.class);
            startActivity(intent);


        });

        buttonLogin.setOnClickListener(view -> {

            String email=editTextEmail.getText().toString().trim();
            String password=editTextPassword.getText().toString().trim();

            if(email.isEmpty()){
              editTextEmail.setError("Enter your email");
                editTextEmail.requestFocus();
                return;
            }

            if(password.isEmpty()){
                editTextPassword.setError("Enter your email");
                editTextPassword.requestFocus();
                return;
            }

            if(password.length()<6){
                editTextPassword.setError("Enter a password with at leas 6 characters");
                editTextPassword.requestFocus();
                return;
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                editTextEmail.setError("Enter a valid  email");
                editTextEmail.requestFocus();
                return;
            }

            progressBar.setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       progressBar.setVisibility(View.GONE);
                       Toast.makeText(SignIn.this,"Logged in successfully!",Toast.LENGTH_LONG).show();

                       startActivity(new Intent(SignIn.this,Dashboard.class));

                   }
                   else {
                       progressBar.setVisibility(View.GONE);
                       Toast.makeText(SignIn.this,"Failed to login,check your credentials and connection!",Toast.LENGTH_LONG).show();
                   }
                }
            });


        });
    }
}