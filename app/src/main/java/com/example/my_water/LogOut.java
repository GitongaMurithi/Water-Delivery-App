package com.example.my_water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.my_water.databinding.ActivityLogOutBinding;


public class LogOut extends DrawerBaseActivity {
    ActivityLogOutBinding activityLogOutBinding;
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLogOutBinding= ActivityLogOutBinding.inflate(getLayoutInflater());
        setContentView(activityLogOutBinding.getRoot());
        allocateActivityTitle("Logout");

        button1=(Button) findViewById(R.id.no);
        button2=(Button) findViewById(R.id.yes);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogOut.this,SignIn.class);
                startActivity(intent);
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogOut.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
    }
}