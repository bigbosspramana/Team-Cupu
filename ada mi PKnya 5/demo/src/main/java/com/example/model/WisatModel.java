package com.example.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TabelRegisterW")
public class WisatModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_wisatawan;

    private String emailw;
    private String passwordw;
    private String konfirmasipasswordw;
    private String namaLengkapw;
    @Enumerated(EnumType.STRING)
    private JenisKelamin jenisKelaminw;
    @Temporal(TemporalType.DATE)
    private Date tanggalLahirw;
    @Enumerated(EnumType.STRING)
    private Kota kotaw;
    private String nomorTeleponw;
    private String role = "wisatawan";
    
    public WisatModel() {
    }

    public WisatModel(String emailw, String passwordw, String konfirmasipasswordw, String namaLengkapw, JenisKelamin jenisKelaminw, Date tanggalLahirw, Kota kotaw, String nomorTeleponw) {
        this.id_wisatawan = UUID.randomUUID(); // Generate UUID
        this.emailw = emailw;
        this.passwordw = passwordw;
        this.konfirmasipasswordw = konfirmasipasswordw;
        this.namaLengkapw = namaLengkapw;
        this.jenisKelaminw = jenisKelaminw;
        this.tanggalLahirw = tanggalLahirw;
        this.kotaw = kotaw;
        this.nomorTeleponw = nomorTeleponw;
    }

    // Getter dan setter
    public UUID getId_wisatawan() {
        return id_wisatawan;
    }

    public void setId_wisatawan(UUID id_wisatawan) {
        this.id_wisatawan = id_wisatawan;
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

    public JenisKelamin getJenisKelaminw() {
        return jenisKelaminw;
    }

    public void setJenisKelaminw(JenisKelamin jenisKelaminw) {
        this.jenisKelaminw = jenisKelaminw;
    }

    public Date getTanggalLahirw() {
        return tanggalLahirw;
    }

    public void setTanggalLahirw(Date tanggalLahirw) {
        this.tanggalLahirw = tanggalLahirw;
    }

    public Kota getKotaw() {
        return kotaw;
    }

    public void setKotaw(Kota kotaw) {
        this.kotaw = kotaw;
    }

    public String getNomorTeleponw() {
        return nomorTeleponw;
    }

    public void setNomorTeleponw(String nomorTeleponw) {
        this.nomorTeleponw = nomorTeleponw;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public enum JenisKelamin {
        LAKI_LAKI, PEREMPUAN
    }

    public enum Kota {
        Jakarta, Bandung, Manokwari, Bali, Yogyakarta, Surabaya, Medan, Makassar, Malang, Lombok, Semarang, Palembang, Manado, Batam, Banjarmasin, Solo, Bogor, Denpasar, Padang, Balikpapan, Pontianak
    }
}
