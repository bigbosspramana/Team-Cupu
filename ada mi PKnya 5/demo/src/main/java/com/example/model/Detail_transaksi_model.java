package com.example.model;

// import java.util.Map;

// import java.util.Map;

// import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DetailTransaksi")
public class Detail_transaksi_model {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_Transaksi", columnDefinition = "VARCHAR(255)")
    private int id_transaksi;

    @Column(name = "ID_Wisatawan", columnDefinition = "VARCHAR(255)")
    private int id_wisatawan;

    @Column(name = "Tanggal_Transaksi", columnDefinition = "VARCHAR(255)")
    private int tgl_transaksi;

    @Column(name = "Metode_Pembayaran", columnDefinition = "VARCHAR(255)")
    private String metodebayar;

    @Column(name = "Status", columnDefinition = "VARCHAR(255)")
    private String status;

    @Column(name = "Diskon", columnDefinition = "INT")
    private int diskon;

    @Column(name = "Total_Setelah_Diskon", columnDefinition = "Decimal")
    private double totalsetelah;

    public Detail_transaksi_model(int id_transaksi, int id_wisatawan, int tgl_transaksi, String metodebayar, String status, int diskon, double totalsetelah) {
        this.id_transaksi = id_transaksi;
        this.id_wisatawan = id_wisatawan;
        this.tgl_transaksi = tgl_transaksi;
        this.metodebayar = metodebayar;
        this.status = status;
        this.diskon = diskon;
        this.totalsetelah = totalsetelah;
    }

    public Detail_transaksi_model() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_wisatawan() {
        return id_wisatawan;
    }

    public void setId_wisatawan(int id_wisatawan) {
        this.id_wisatawan = id_wisatawan;
    }

    public int getTgl_transaksi() {
        return tgl_transaksi;
    }

    public void setTgl_transaksi(int tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

    public String getMetodebayar() {
        return metodebayar;
    }

    public void setMetodebayar(String metodebayar) {
        this.metodebayar = metodebayar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDiskon() {
        return diskon;
    }

    public void setDiskon(int diskon) {
        this.diskon = diskon;
    }

    public double getTotalsetelah() {
        return totalsetelah;
    }

    public void setTotalsetelah(double totalsetelah) {
        this.totalsetelah = totalsetelah;
    }

}