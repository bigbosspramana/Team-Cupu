package com.helloIftekhar.springJwt.service;

import com.helloIftekhar.springJwt.model.UserWisat;
import com.helloIftekhar.springJwt.repository.TokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.access-token-expiration}")
    private long accessTokenExpire;

    @Value("${application.security.jwt.refresh-token-expiration}")
    private long refreshTokenExpire;

    private final TokenRepository tokenRepository;

    public JwtService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isValid(String token, UserWisat user) {
        String username = extractUsername(token);

        boolean validToken = tokenRepository
                .findByAccessToken(token)
                .map(t -> !t.isLoggedOut())
                .orElse(false);

        return (username.equals(user.getEmailw())) && !isTokenExpired(token) && validToken;
    }

    public boolean isValidRefreshToken(String token, UserWisat user) {
        String username = extractUsername(token);

        boolean validRefreshToken = tokenRepository
                .findByRefreshToken(token)
                .map(t -> !t.isLoggedOut())
                .orElse(false);

        return (username.equals(user.getEmailw())) && !isTokenExpired(token) && validRefreshToken;
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = Jwts.parserBuilder() // Perbaiki pemanggilan metode menjadi parserBuilder()
                .setSigningKey(getSigningKey()) 
                .build() // Tambahkan build() untuk membuat parser
                .parseClaimsJws(token)
                .getBody();
        return resolver.apply(claims);
    }

    public String generateAccessToken(UserWisat user) {
        return generateToken(user, accessTokenExpire);
    }

    public String generateRefreshToken(UserWisat user) {
        return generateToken(user, refreshTokenExpire);
    }

    private String generateToken(UserWisat user, long expireTime) {
        return Jwts.builder()
                .setSubject(user.getEmailw())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .signWith(getSigningKey()) 
                .compact();
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = secretKey.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
