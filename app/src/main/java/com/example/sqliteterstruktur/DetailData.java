package com.example.sqliteterstruktur;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailData extends AppCompatActivity {
    TextView tx_nama, tx_no, tx_tanggal, tx_alamat, tx_jenkel;
    public static String CURRENT_MAHASISWA = "extra_mahasiswa";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);
        Mahasiswa ms = new Mahasiswa();
        initial();
        tx_no.setText(ms.getNomor());
        tx_nama.setText(ms.getNama());
        tx_tanggal.setText(ms.getTanggal());
        tx_alamat.setText(ms.getAlamat());
        if (ms.getJenkel() == "L") {
            tx_jenkel.setText("Laki - Laki");
        } else if(ms.getJenkel() == "P") {
            tx_jenkel.setText("Perempuan");
        }else{
            tx_jenkel.setText(null);
        }

    }

    private void initial(){
        tx_nama = (TextView) findViewById(R.id.edit_nama);
        tx_alamat = (TextView) findViewById(R.id.edit_alamat);
        tx_jenkel = (TextView) findViewById(R.id.edit_jenkel);
        tx_no = (TextView) findViewById(R.id.edit_nomor);
        tx_tanggal = (TextView) findViewById(R.id.edit_tanggal);
    }
}
