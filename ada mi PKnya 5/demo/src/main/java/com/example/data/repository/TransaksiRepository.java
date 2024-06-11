package com.example.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import com.example.model.ProdukModel;
import com.example.model.TransaksiModel;

@Repository
public interface TransaksiRepository extends JpaRepository<TransaksiModel, Long> {
}
