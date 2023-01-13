package com.example.my_water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Card2 extends AppCompatActivity {
    Button button;
    ImageView imageView1,imageView2;
    TextView textView,textView1;
    public int value=1;
    int price=700;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card2);


        button=findViewById(R.id.orderBtn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Card2.this,Address.class);
                startActivity(intent);
            }
        });

        textView1=(TextView) findViewById(R.id.textView20);
        textView1.setText(String.valueOf(price));
        textView=(TextView) findViewById(R.id.textCard2);
        textView.setText(String.valueOf(value));
       imageView1=(ImageView) findViewById(R.id.decrease2);
        imageView2=(ImageView) findViewById(R.id.increase2);


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(value>1){
                    value-=1;
                    price-=700;
                }
                textView.setText(String.valueOf(value));
                textView1.setText(String.valueOf(price));

            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            value+=1;
            price=price+700;
                textView.setText(String.valueOf(value));
                textView1.setText(String.valueOf(price));
            }
        });

    }
}