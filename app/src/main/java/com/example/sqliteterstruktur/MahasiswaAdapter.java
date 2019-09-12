package com.example.sqliteterstruktur;

import android.content.Context;
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
    List<Mahasiswa> listMahasiswa;

    public MahasiswaAdapter(Context context, List<Mahasiswa> listMahasiswa, OnUserClickListener listener) {
        this.context = context;
        this.listMahasiswa = listMahasiswa;
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
        final Mahasiswa currentMahasiswa = listMahasiswa.get(position);
        holder.edt_nomor.setText(currentMahasiswa.getNomor());
        holder.edt_nama.setText(currentMahasiswa.getNama());
        holder.edt_tanggal.setText(currentMahasiswa.getTanggal());
        holder.edt_jenkel.setText(currentMahasiswa.getJenkel());
        holder.edt_alamat.setText(currentMahasiswa.getAlamat());
    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();
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
}
