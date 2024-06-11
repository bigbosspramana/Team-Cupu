package com.example.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.AdminModel;
import com.example.model.Detail_transaksi_model;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel, Long>{

    AdminModel save(Detail_transaksi_model newData);

    
}