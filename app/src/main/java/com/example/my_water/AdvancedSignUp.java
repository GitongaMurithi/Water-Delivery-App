package com.example.my_water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AdvancedSignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinner;
    String[] options = {"Select","Vendor", "Customer"};
    String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_sign_up);

        spinner=findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
selected=spinner.getSelectedItem().toString();
if (selected.equals("Select")){
    Toast.makeText(this, "Select signup mode!", Toast.LENGTH_SHORT).show();
    return;
}
if (selected.equals("Vendor")){
    startActivity(new Intent(AdvancedSignUp.this,SignUp.class));
    return;
}
if (selected.equals("Customer")){
    startActivity(new Intent(AdvancedSignUp.this,SignIn.class));
}
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}