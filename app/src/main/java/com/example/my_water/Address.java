package com.example.my_water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Address extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        EditText editText=(EditText) findViewById(R.id.address);


        Button button=(Button) findViewById(R.id.addressBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().isEmpty()){
                    editText.setError("Enter your address");
                    editText.requestFocus();
                }
                else {
                    Toast.makeText(Address.this,"Thank you for your order!",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(Address.this,Dashboard.class);
                    startActivity(intent);
                }

            }
        });
    }
}