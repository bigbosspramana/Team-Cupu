package com.example.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Detail_transaksi_model;

@Repository
public interface Detail_Repository extends JpaRepository<Detail_transaksi_model, Long> {
    // Tambahkan method tambahan sesuai kebutuhan di sini
}
