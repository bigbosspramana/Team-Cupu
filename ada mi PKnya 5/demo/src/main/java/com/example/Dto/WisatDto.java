package com.example.Dto;

import com.example.model.WisatModel;

import java.util.Date;

public class WisatDto {

    private String emailw;
    private String passwordw;
    private String konfirmasipasswordw;
    private String namaLengkapw;
    private WisatModel.JenisKelamin jenisKelaminw;
    private Date tanggalLahirw;
    private WisatModel.Kota kotaw;
    private String nomorTeleponw;

    // Constructors, getters, and setters
    public WisatDto() {}

    public WisatDto(String emailw, String passwordw, String konfirmasipasswordw, String namaLengkapw,
                        WisatModel.JenisKelamin jenisKelaminw, Date tanggalLahirw, WisatModel.Kota kotaw,
                        String nomorTeleponw) {
        this.emailw = emailw;
        this.passwordw = passwordw;
        this.konfirmasipasswordw = konfirmasipasswordw;
        this.namaLengkapw = namaLengkapw;
        this.jenisKelaminw = jenisKelaminw;
        this.tanggalLahirw = tanggalLahirw;
        this.kotaw = kotaw;
        this.nomorTeleponw = nomorTeleponw;
    }

    public String getEmailw() {
        return emailw;
    }

    public void setEmailw(String emailw) {
        this.emailw = emailw;
    }

    public String getPasswordw() {
        return passwordw;
    }

    public void setPasswordw(String passwordw) {
        this.passwordw = passwordw;
    }

    public String getKonfirmasipasswordw() {
        return konfirmasipasswordw;
    }

    public void setKonfirmasipasswordw(String konfirmasipasswordw) {
        this.konfirmasipasswordw = konfirmasipasswordw;
    }

    public String getNamaLengkapw() {
        return namaLengkapw;
    }

    public void setNamaLengkapw(String namaLengkapw) {
        this.namaLengkapw = namaLengkapw;
    }

    public WisatModel.JenisKelamin getJenisKelaminw() {
        return jenisKelaminw;
    }

    public void setJenisKelaminw(WisatModel.JenisKelamin jenisKelaminw) {
        this.jenisKelaminw = jenisKelaminw;
    }

    public Date getTanggalLahirw() {
        return tanggalLahirw;
    }

    public void setTanggalLahirw(Date tanggalLahirw) {
        this.tanggalLahirw = tanggalLahirw;
    }

    public WisatModel.Kota getKotaw() {
        return kotaw;
    }

    public void setKotaw(WisatModel.Kota kotaw) {
        this.kotaw = kotaw;
    }

    public String getNomorTeleponw() {
        return nomorTeleponw;
    }

    public void setNomorTeleponw(String nomorTeleponw) {
        this.nomorTeleponw = nomorTeleponw;
    }
}
