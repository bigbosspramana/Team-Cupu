package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Produk")
public class ProdukModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_Produk", columnDefinition = "VARCHAR(255)")
    private int id_produk;

    @Column(name = "Tanggalp", columnDefinition = "VARCHAR(255)")
    private int tanggalp;

    @Column(name = "Lokasi", columnDefinition = "VARCHAR(255)")
    private String lokasi;

    @Column(name = "Harga", columnDefinition = "VARCHAR(255)")
    private double harga;

    @Column(name = "Foto", columnDefinition = "BLOB")
    private String foto;

    @Column(name = "Kategori", columnDefinition = "VARCHAR(255)")
    private String kategori;

    @Column(name = "Deskripsi", columnDefinition = "VARCHAR(255)")
    private String deskripsi;

    public ProdukModel(int id_produk, int tanggalp, String lokasi, double harga, String foto, String kategori, String deskripsi) {
        this.id_produk = id_produk;
        this.tanggalp = tanggalp;
        this.lokasi = lokasi;
        this.harga = harga;
        this.foto = foto;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
    }

    public ProdukModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public int getTanggalp() {
        return tanggalp;
    }

    public void setTanggalp(int tanggalp) {
        this.tanggalp = tanggalp;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    
}
