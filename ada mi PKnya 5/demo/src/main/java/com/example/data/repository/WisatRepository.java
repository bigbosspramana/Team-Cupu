package com.example.data.repository;

import com.example.model.WisatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WisatRepository extends JpaRepository<WisatModel, UUID> {
    WisatModel findByEmailw(String emailw);
    boolean existsByEmailw(String emailw);
}
