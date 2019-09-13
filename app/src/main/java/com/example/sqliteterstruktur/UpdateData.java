package com.example.sqliteterstruktur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class UpdateData extends AppCompatActivity {
    public static String CURRENT_MAHASISWA = "extra_mahasiswa";
    EditText edt_nomor, edt_nama, edt_tanggal, edt_jenkel, edt_alamat;
    TextView tx_simpan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_data);
        Mahasiswa mahasiswa = new Mahasiswa();

        edt_nomor.setText(Integer.parseInt(mahasiswa.getNomor()+""));
        edt_nama.setText(mahasiswa.getNama()+"");
        edt_tanggal.setText(mahasiswa.getTanggal()+"");
        edt_jenkel.setText(mahasiswa.getJenkel()+"");
        edt_alamat.setText(mahasiswa.getAlamat()+"");
        tx_simpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(UpdateData.this);
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setNomor(Integer.parseInt(edt_nomor.getText().toString()));
                mahasiswa.setNama(edt_nama.getText().toString());
                mahasiswa.setTanggal(edt_tanggal.getText().toString());
                mahasiswa.setJenkel(edt_jenkel.getText().toString());
                mahasiswa.setAlamat(edt_alamat.getText().toString());
                db.update(mahasiswa);

                Intent i  = new Intent(UpdateData.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}
