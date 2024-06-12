package com.helloIftekhar.springJwt.service;

import com.helloIftekhar.springJwt.model.AuthenticationResponse;
import com.helloIftekhar.springJwt.model.Token;
import com.helloIftekhar.springJwt.model.UserWisat;
import com.helloIftekhar.springJwt.repository.TokenRepository;
import com.helloIftekhar.springJwt.repository.UserWisatRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    private final UserWisatRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserWisatRepository repository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 TokenRepository tokenRepository,
                                 AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.tokenRepository = tokenRepository;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(UserWisat request) {
        // check if user already exists. if exist then authenticate the user
        if (repository.findByEmailw(request.getEmailw()).isPresent()) {
            return new AuthenticationResponse(null, null, "User already exists");
        }

        // Check if password matches the confirmation password
        if (!request.getPasswordw().equals(request.getKonfirmasipasswordw())) {
            return new AuthenticationResponse(null, null, "Password and confirmation password do not match");
        }

        // Proceed with user registration
        UserWisat user = new UserWisat();
        user.setEmailw(request.getEmailw());
        user.setPasswordw(passwordEncoder.encode(request.getPasswordw()));
        user.setNamaLengkapw(request.getNamaLengkapw());
        user.setJenisKelaminw(request.getJenisKelaminw());
        user.setTanggalLahirw(request.getTanggalLahirw());
        user.setKotaw(request.getKotaw());
        user.setNomorTeleponw(request.getNomorTeleponw());
        user.setRole(request.getRole());

        user = repository.save(user);

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        saveUserToken(accessToken, refreshToken, user);

        return new AuthenticationResponse(accessToken, refreshToken, "User registration was successful");
    }

    public AuthenticationResponse authenticate(UserWisat request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmailw(),
                        request.getPasswordw()
                )
        );

        UserWisat user = repository.findByEmailw(request.getEmailw()).orElseThrow();
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        revokeAllTokenByUser(user);
        saveUserToken(accessToken, refreshToken, user);

        return new AuthenticationResponse(accessToken, refreshToken, "User login was successful");
    }

    private void revokeAllTokenByUser(UserWisat user) {
        List<Token> validTokens = tokenRepository.findAllByUserIdAndLoggedOutFalse(user.getId());
        if (validTokens.isEmpty()) {
            return;
        }

        validTokens.forEach(t -> t.setLoggedOut(true));
        tokenRepository.saveAll(validTokens);
    }

    private void saveUserToken(String accessToken, String refreshToken, UserWisat user) {
        Token token = new Token();
        token.setAccessToken(accessToken);
        token.setRefreshToken(refreshToken);
        token.setLoggedOut(false);
        token.setUser(user);
        tokenRepository.save(token);
    }

    public ResponseEntity<AuthenticationResponse> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response) {
        // extract the token from authorization header
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        String token = authHeader.substring(7);

        // extract email from token
        String email = jwtService.extractUsername(token);

        // check if the user exists in database
        UserWisat user = repository.findByEmailw(email)
                .orElseThrow(() -> new RuntimeException("No user found"));

        // check if the token is valid
        if (jwtService.isValidRefreshToken(token, user)) {
            // generate access token
            String accessToken = jwtService.generateAccessToken(user);
            String refreshToken = jwtService.generateRefreshToken(user);

            revokeAllTokenByUser(user);
            saveUserToken(accessToken, refreshToken, user);

            return new ResponseEntity<>(new AuthenticationResponse(accessToken, refreshToken, "New token generated"), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
