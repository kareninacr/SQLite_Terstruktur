package com.example.sqliteterstruktur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    TextView LihatData, InputData, InfoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        InputData = (TextView)findViewById(R.id.tvinput);
        InputData.setOnClickListener(this);
        LihatData.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvinput :
                Intent InputData = new Intent(DashboardActivity.this, InputData.class);
                startActivity(InputData);
                break;
            case R.id.tvlihat :
                Intent LihatData = new Intent(DashboardActivity.this, MainCreate.class);
                startActivity(LihatData);
                break;
        }
    }
}
