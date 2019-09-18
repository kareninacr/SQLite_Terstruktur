package com.example.sqliteterstruktur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    public static String CURRENT_MAHASISWA = "extra_mahasiswa";
    EditText edt_nomor, edt_nama, edt_tanggal, edt_jenkel, edt_alamat;
    LinearLayout simpan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Mahasiswa mahasiswa = getIntent().getParcelableExtra(CURRENT_MAHASISWA);
        initial();

        edt_nomor.setText(mahasiswa.getNomor()+"");
        edt_nama.setText(mahasiswa.getNama()+"");
        edt_tanggal.setText(mahasiswa.getTanggal()+"");
        edt_jenkel.setText(mahasiswa.getJenkel()+"");
        edt_alamat.setText(mahasiswa.getAlamat()+"");
        simpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(UpdateActivity.this);
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setNomor(Integer.parseInt(edt_nomor.getText().toString()));
                mahasiswa.setNama(edt_nama.getText().toString());
                mahasiswa.setTanggal(edt_tanggal.getText().toString());
                mahasiswa.setJenkel(edt_jenkel.getText().toString());
                mahasiswa.setAlamat(edt_alamat.getText().toString());
                db.update(mahasiswa);

                Intent i  = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void initial() {
        edt_nomor    = findViewById(R.id.edt_nomor);
        edt_nama     = findViewById(R.id.edt_nama);
        edt_tanggal  = findViewById(R.id.edt_tanggal);
        edt_jenkel   = findViewById(R.id.edt_jenkel);
        edt_alamat   = findViewById(R.id.edt_alamat);
        simpan       = findViewById(R.id.simpan);
    }
}
