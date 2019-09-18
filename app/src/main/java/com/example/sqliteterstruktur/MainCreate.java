package com.example.sqliteterstruktur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainCreate extends AppCompatActivity implements MahasiswaAdapter.OnUserClickListener{
    RecyclerView recyclerView;
    TextView txt_input;
    RecyclerView.LayoutManager layoutManager;
    List<Mahasiswa> listPersonInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mahasiswa_list_item);
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(MainCreate.this);
        recyclerView.setLayoutManager(layoutManager);
        txt_input = findViewById(R.id.txt_input_data);
        txt_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCreate.this, InputActivity.class);
                startActivity(i);
            }
        });
        setupRecyclerView();

    }
    private void setupRecyclerView() {
        DatabaseHelper db = new DatabaseHelper(MainCreate.this);
        listPersonInfo = db.selectUserData();
        MahasiswaAdapter adapter = new MahasiswaAdapter(this, listPersonInfo, (MahasiswaAdapter.OnUserClickListener) this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onUserClick(Mahasiswa currentMahasiswa, String action) {
        if(action.equals("Edit")) {
            Intent i = new Intent(MainCreate.this, UpdateActivity.class);
            i.putExtra(UpdateActivity.CURRENT_MAHASISWA, currentMahasiswa);
            startActivity(i);
        }
        if(action.equals("Delete")) {
            DatabaseHelper db = new DatabaseHelper(MainCreate.this);
            db.delete(currentMahasiswa.getNama());
            setupRecyclerView();
        }
        if(action.equals("View")) {
            Intent i = new Intent(MainCreate.this, DetailActivity.class);
            i.putExtra(DetailActivity.CURRENT_MAHASISWA,currentMahasiswa);
            startActivity(i);
        }
    }
}
