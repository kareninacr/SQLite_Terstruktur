package com.example.sqliteterstruktur;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.UserViewHolder> {
    Context context;
    OnUserClickListener listener;
    List<Mahasiswa> listPersonInfo;

    public MahasiswaAdapter(Context context, List<Mahasiswa> listPersonInfo, OnUserClickListener listener) {
        this.context = context;
        this.listPersonInfo = listPersonInfo;
        this.listener = listener;
    }

    public interface OnUserClickListener {
        void onUserClick(Mahasiswa currentMahasiswa, String action);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_data, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, final int position) {
        final Mahasiswa currentMahasiswa = listPersonInfo.get(position);
        holder.edt_nomor.setText(currentMahasiswa.getNomor());
        holder.edt_nama.setText(currentMahasiswa.getNama());
        holder.edt_nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice(currentMahasiswa);
            }
        });
        holder.edt_tanggal.setText(currentMahasiswa.getTanggal());
        holder.edt_jenkel.setText(currentMahasiswa.getJenkel());
        holder.edt_alamat.setText(currentMahasiswa.getAlamat());
    }

    @Override
    public int getItemCount() {
        return listPersonInfo.size();

    }

    public void choice(final Mahasiswa msh) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("Pilihan");
        CharSequence[] items = {"Lihat Data", "Update Data", "Hapus Data"};
        alertDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0 :
                        viewData(msh);
                        break;
                    case 1 :
                        updateData(msh);
                        break;
                    case 3:
                        deleteData(msh);
                        break;
                }
            }
        });
        alertDialog.show();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        EditText edt_nomor, edt_nama, edt_tanggal, edt_jenkel, edt_alamat;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            edt_nomor   = itemView.findViewById(R.id.edt_nomor);
            edt_nama    = itemView.findViewById(R.id.edt_nama);
            edt_tanggal = itemView.findViewById(R.id.edt_tanggal);
            edt_jenkel  = itemView.findViewById(R.id.edt_jenkel);
            edt_alamat  = itemView.findViewById(R.id.edt_alamat);
        }
    }
    private void updateData(Mahasiswa currentMahasiswa) {
        listener.onUserClick(currentMahasiswa, "Edit");
    }
    private void viewData(Mahasiswa currentMahasiswa) {
        listener.onUserClick(currentMahasiswa, "View");
    }
    private void deleteData(Mahasiswa currentMahasiswa){
        listener.onUserClick(currentMahasiswa, "Delete");
    }
}
