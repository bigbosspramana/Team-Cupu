package com.example.data.repository;

import com.example.model.VendModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendRepository extends JpaRepository<VendModel, UUID> {
    VendModel findByEmailv(String emailv);
    boolean existsByEmailv(String emailv);
}