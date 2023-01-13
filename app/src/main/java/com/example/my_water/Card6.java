package com.example.my_water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Card6 extends AppCompatActivity {
    ImageView imageView1,imageView2;
    TextView textView,textView1;
    public int value=1;
    public int price=800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card6);

        Button button=(Button) findViewById(R.id.orderBtn6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Card6.this,Address.class);
                startActivity(intent);
            }
        });
        textView1=(TextView) findViewById(R.id.textView15);
        textView1.setText(String.valueOf(price));
        textView=(TextView) findViewById(R.id.textCard6);
        textView.setText(String.valueOf(value));
        imageView1=(ImageView) findViewById(R.id.decrease6);
        imageView2=(ImageView) findViewById(R.id.increase6);


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(value>1){
                    value-=1;
                    price-=800;
                }
                textView.setText(String.valueOf(value));
                textView1.setText(String.valueOf(price));

            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value+=1;
                price=price+800;
                textView.setText(String.valueOf(value));
                textView1.setText(String.valueOf(price));
            }
        });

    }
}