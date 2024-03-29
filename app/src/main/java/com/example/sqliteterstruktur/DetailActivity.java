package com.example.sqliteterstruktur;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    public static String CURRENT_MAHASISWA = "extra_mahasiswa";
    TextView tx_nomor, tx_nama, tx_tanggal, tx_jenkel,tx_alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Mahasiswa ms = getIntent().getParcelableExtra(CURRENT_MAHASISWA);
        initial();
        tx_nomor.setText(ms.getNomor()+"");
        tx_nama.setText(ms.getNama());
        if (ms.getJenkel() == "L") {
            tx_jenkel.setText("Laki - Laki");
        } else if(ms.getJenkel() == "P") {
            tx_jenkel.setText("Perempuan");
        }else{
            tx_jenkel.setText(null);
        }
        tx_tanggal.setText(ms.getTanggal());
        tx_alamat.setText(ms.getAlamat());
    }

    private void initial(){
        tx_nomor    = (TextView) findViewById(R.id.edit_nomor);
        tx_nama     = (TextView) findViewById(R.id.edit_nama);
        tx_jenkel   = (TextView) findViewById(R.id.edit_jenkel);
        tx_tanggal  = (TextView) findViewById(R.id.edit_tanggal);
        tx_alamat   = (TextView) findViewById(R.id.edit_alamat);
    }
}
