package com.example.sqliteterstruktur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    EditText edt_nomor, edt_nama, edt_tanggal, edt_jenkel, edt_alamat;
    LinearLayout simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        init();
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(InputActivity.this);
                Mahasiswa ms = new Mahasiswa();
                ms.setNomor(Integer.parseInt(edt_nomor.getText().toString()));
                ms.setNama(edt_nama.getText().toString());
                ms.setJenkel(edt_jenkel.getText().toString());
                ms.setTanggal(edt_tanggal.getText().toString());
                ms.setAlamat(edt_alamat.getText().toString());

                db.insert(ms);
                Intent i = new Intent(InputActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void init(){
        edt_nomor   = findViewById(R.id.edt_nomor);
        edt_nama    = findViewById(R.id.edt_nama);
        edt_tanggal = findViewById(R.id.edt_tanggal);
        edt_jenkel  = findViewById(R.id.edt_jenkel);
        edt_alamat  = findViewById(R.id.edt_alamat);
        simpan      = findViewById(R.id.simpan);
    }

}
