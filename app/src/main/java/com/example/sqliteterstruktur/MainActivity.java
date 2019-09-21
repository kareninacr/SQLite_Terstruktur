package com.example.sqliteterstruktur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MahasiswaAdapter.OnUserClickListener {
    RecyclerView recyclerView;
    LinearLayout inputData;
    RecyclerView.LayoutManager layoutManager;
    List<Mahasiswa> listPersonInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_data);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        inputData = findViewById(R.id.inputData);
        inputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InputActivity.class);
                startActivity(i);
            }
        });
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        DatabaseHelper db = new DatabaseHelper(MainActivity.this);
        listPersonInfo = db.selectUserData();
        MahasiswaAdapter adapter = new MahasiswaAdapter(MainActivity.this, listPersonInfo,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onUserClick(Mahasiswa mahasiswa, String action) {
        if(action.equals("Edit")){
            Intent i = new Intent(MainActivity.this, UpdateActivity.class);
            i.putExtra(UpdateActivity.CURRENT_MAHASISWA, mahasiswa);
            startActivity(i);
        }
        if(action.equals("Delete")){
            DatabaseHelper db = new DatabaseHelper(MainActivity.this);
            db.delete(mahasiswa.getNama());
            setupRecyclerView();
        }
        if(action.equals("View")) {
            Intent i = new Intent(MainActivity.this, DetailActivity.class);
            i.putExtra(DetailActivity.CURRENT_MAHASISWA, mahasiswa);
            startActivity(i);
        }
    }
}
