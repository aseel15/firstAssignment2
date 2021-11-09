package edu.cs.firstassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread() {
            @Override
            public void run() {
               // int n = 0;
                try {
                    for(int n=0;n<2500;n+=100){
                   // while (n < 2800) {

                        sleep(50);
                       // n += 100;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(MainActivity.this, MainActivity1.class);
                    startActivity(intent);
                }

            }
            };
    thread.start();
}


    }



