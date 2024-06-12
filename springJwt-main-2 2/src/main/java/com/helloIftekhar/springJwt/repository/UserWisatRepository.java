package com.helloIftekhar.springJwt.repository;

import com.helloIftekhar.springJwt.model.UserWisat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserWisatRepository extends JpaRepository<UserWisat, Integer> {
    Optional<UserWisat> findByEmailw(String emailw);
}
