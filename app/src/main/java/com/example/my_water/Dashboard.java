package com.example.my_water;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.my_water.databinding.ActivityDashboardBinding;

public class Dashboard extends DrawerBaseActivity {

    ActivityDashboardBinding activityDashboardBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding=ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardBinding.getRoot());
        allocateActivityTitle("Dashboard");

        CardView cardView1 = (CardView) findViewById(R.id.twentyLitres);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,ItemSelected.class);
                startActivity(intent);
            }
        });

        CardView cardView2=(CardView) findViewById(R.id.card2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,Card2.class);
                startActivity(intent);
            }
        });

        CardView cardView3=(CardView) findViewById(R.id.card3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,Card3.class);
                startActivity(intent);
            }
        });

        CardView cardView4=(CardView) findViewById(R.id.card4);
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,Card4.class);
                startActivity(intent);
            }
        });

        CardView cardView5=(CardView) findViewById(R.id.card5);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,Card5.class);
                startActivity(intent);
            }
        });

        CardView cardView6=(CardView) findViewById(R.id.card6);
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,Card6.class);
                startActivity(intent);
            }
        });



    }
}