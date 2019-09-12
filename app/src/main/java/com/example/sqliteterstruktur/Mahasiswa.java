package com.example.sqliteterstruktur;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {
    String nama,tanggal,jenkel,alamat,nomor;


    public String  getNomor() {
        return nomor;
    }

    public void setNomor(String nomor)
    {
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJenkel() {
        return jenkel;
    }

    public void setJenkel(String jenkel) {
        this.jenkel = jenkel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.tanggal);
        dest.writeString(this.jenkel);
        dest.writeString(this.alamat);
        dest.writeString(this.nomor);
    }

    public Mahasiswa() {
    }

    protected Mahasiswa(Parcel in) {
        this.nama = in.readString();
        this.tanggal = in.readString();
        this.jenkel = in.readString();
        this.alamat = in.readString();
        this.nomor = in.readString();
    }

    public static final Parcelable.Creator<Mahasiswa> CREATOR = new Parcelable.Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel source) {
            return new Mahasiswa(source);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };
}
