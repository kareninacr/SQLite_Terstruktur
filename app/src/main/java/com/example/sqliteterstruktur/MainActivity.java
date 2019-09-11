package com.example.sqliteterstruktur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException ex) {
                    ex.printStackTrace();
                }finally {
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                }
            }
        });
        thread.start();
    }
}
