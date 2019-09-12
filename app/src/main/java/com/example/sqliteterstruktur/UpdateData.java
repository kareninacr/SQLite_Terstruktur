package com.example.sqliteterstruktur;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class UpdateData extends AppCompatActivity {
    EditText edt_nomor, edt_nama, edt_tanggal, edt_jenkel, edt_alamat;
    TextView tx_simpan;
    DatabaseHelper dbhelper = new DatabaseHelper(this);
    String nama, tanggal, jenkel, alamat;
    int nomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_data);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




    }
}
