package com.example.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import com.example.model.ProdukModel;
import com.example.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    boolean existsByUsername(Object username);
}
