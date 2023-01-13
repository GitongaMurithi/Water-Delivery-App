package com.example.my_water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=findViewById(R.id.textView);

       // getSupportActionBar().hide();
       getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        textView.animate().translationX(1000).setDuration(1000).setStartDelay(2000);

        Thread thread=new Thread(){
            public void run(){
                try {
                    Thread.sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                     Intent intent=new Intent(MainActivity.this,Register.class);
                     startActivity(intent);
                     finish();
                }
            }
        };
        thread.start();

}
}