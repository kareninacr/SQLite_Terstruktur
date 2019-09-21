package com.example.sqliteterstruktur;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row_item, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, final int position) {
        final Mahasiswa currentMahasiswa = listPersonInfo.get(position);
        holder.tx_nama.setText(currentMahasiswa.getNama());
        holder.tx_nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choise(currentMahasiswa);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPersonInfo.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tx_nama;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tx_nama = itemView.findViewById(R.id.tvNama);
        }
    }

        public void choise(final Mahasiswa msh){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
            alertDialog.setTitle("Pilihan");
            CharSequence[] items = {"Lihat Data", "Update Data", "Hapus Data"};
            alertDialog.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            viewData(msh);
                            break;
                        case 1:
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

    private void updateData(Mahasiswa currentMahasiswa) {
        listener.onUserClick(currentMahasiswa, "Edit");
    }

    private void viewData(Mahasiswa currentMahasiswa) {
        listener.onUserClick(currentMahasiswa, "View");
    }

    private void deleteData(Mahasiswa currentMahasiswa) {
        listener.onUserClick(currentMahasiswa, "Delete");
    }
}
