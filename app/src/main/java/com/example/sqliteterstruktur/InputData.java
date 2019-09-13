package com.example.sqliteterstruktur;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InputData extends AppCompatActivity implements View.OnClickListener{
    EditText edtnomor, edtnama, edttanggal, edtjenkel, edtalamat;
    TextView submit;
    DatabaseHelper db = new DatabaseHelper(this);
    Mahasiswa po = new Mahasiswa();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_data);
        init();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                po.setNomor(Integer.parseInt(edtnomor.getText().toString()));
                po.setNama(edtnama.getText().toString());
                po.setTanggal(edttanggal.getText().toString());
                po.setJenkel(edtjenkel.getText().toString());
                po.setAlamat(edtalamat.getText().toString());
                db.insert(po);

            }
        });

    }

    private void init(){
        edtnomor = (EditText) findViewById(R.id.edt_nomor);
        edtnama = (EditText) findViewById(R.id.edt_nama);
        edttanggal = (EditText) findViewById(R.id.edt_tanggal);
        edtjenkel = (EditText) findViewById(R.id.edt_jenkel);
        edtalamat = (EditText) findViewById(R.id.edt_alamat);
        submit = (TextView) findViewById(R.id.tx_simpan);

    }

    @Override
    public void onClick(View view) {

    }
}
