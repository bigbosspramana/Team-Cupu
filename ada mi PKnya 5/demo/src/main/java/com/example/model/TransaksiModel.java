package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaksi")
public class TransaksiModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_Transaksi", columnDefinition = "VARCHAR(255)")
    private int id_transaksi;

    @Column(name = "ID_Produk", columnDefinition = "VARCHAR(255)")
    private int id_produk;

    @Column(name = "Total_Harga", columnDefinition = "VARCHAR(255)")
    private double totalharga;

    public TransaksiModel(int id_transaksi, int id_produk, double totalharga) {
        this.id_transaksi = id_transaksi;
        this.id_produk = id_produk;
        this.totalharga = totalharga;
    }

    public TransaksiModel() {
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

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public double getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(double totalharga) {
        this.totalharga = totalharga;
    }
}
