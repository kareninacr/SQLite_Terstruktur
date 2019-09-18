package com.example.sqliteterstruktur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;


import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout lihatdata, tambahdata, informasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initialize();

        lihatdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, InputActivity.class);
                startActivity(i);
            }
        });

        informasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, InformasiActivity.class);
                startActivity(i);
            }
        });
    }

    private void initialize() {
     lihatdata  = (LinearLayout) findViewById(R.id.lihatdata);
     tambahdata = (LinearLayout) findViewById(R.id.tambahdata);
     informasi  = (LinearLayout) findViewById(R.id.informasi);
    }
}
