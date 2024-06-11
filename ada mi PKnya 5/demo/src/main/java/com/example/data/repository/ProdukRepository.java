package com.example.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.ProdukModel;

@Repository
public interface ProdukRepository extends JpaRepository<ProdukModel, Long> {
}
