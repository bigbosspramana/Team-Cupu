package com.helloIftekhar.springJwt.repository;

import com.helloIftekhar.springJwt.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
    Optional<Token> findByAccessToken(String accessToken);
    Optional<Token> findByRefreshToken(String refreshToken);
    List<Token> findAllByUserIdAndLoggedOutFalse(Integer userId); // Perbaikan metode yang diinginkan
}
