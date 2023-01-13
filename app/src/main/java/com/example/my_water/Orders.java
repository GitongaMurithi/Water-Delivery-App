package com.example.my_water;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.my_water.databinding.ActivityOrdersBinding;

public class Orders extends DrawerBaseActivity {

    ActivityOrdersBinding activityOrdersBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrdersBinding=ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(activityOrdersBinding.getRoot());
        allocateActivityTitle("Orders");

    }
}