package com.example.sqliteterstruktur;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainInput extends AppCompatActivity implements View.OnClickListener, RecyclerViewAdapter.OnUserClickListener {
    RecyclerView recyclerView;
    EditText edt_nomor, edt_nama, edt_tanggal, edt_jenkel, edt_alamat;
    TextView tx_simpan;
    Context context;
    List<Mahasiswa> mahasiswaList;

    public MainInput() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.input_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getActivity();
        recyclerView = view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        edt_nomor = view.findViewById(R.id.edt_nomor);
        edt_nama = view.findViewById(R.id.edt_nama);
        edt_tanggal = view.findViewById(R.id.edt_tanggal);
        edt_jenkel = view.findViewById(R.id.edt_jenkel);
        edt_alamat = view.findViewById(R.id.edt_alamat);
        tx_simpan = view.findViewById(R.id.tx_simpan);

    }
}
