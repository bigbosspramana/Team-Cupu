package com.example.controller;

import com.example.model.VendModel;
import com.example.model.WisatModel;
import com.example.service.AuthResponse;
import com.example.service.AuthService;
import com.example.service.LoginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3007")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register/wisatawan")
    public ResponseEntity<?> registerWisatawan(@RequestBody WisatModel signupRequest) {
        try {
            AuthResponse response = authService.registerWisatawan(signupRequest);
            if (!response.isSuccess()) {
                return ResponseEntity.badRequest().body("Gagal mendaftar sebagai wisatawan: " + response.getMessage());
            }
            return ResponseEntity.ok("Sukses mendaftar sebagai wisatawan: " + response.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Gagal mendaftar sebagai wisatawan: Silakan coba lagi nanti.");
        }
    }

    @PostMapping("/register/vendor")
    public ResponseEntity<?> registerVendor(@RequestBody VendModel signupRequest) {
        try {
            AuthResponse response = authService.registerVendor(signupRequest);
            if (!response.isSuccess()) {
                return ResponseEntity.badRequest().body("Gagal mendaftar sebagai vendor: " + response.getMessage());
            }
            return ResponseEntity.ok("Sukses mendaftar sebagai vendor: " + response.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Gagal mendaftar sebagai vendor: Silakan coba lagi nanti.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            AuthResponse response = authService.loginUser(loginRequest);
            if (!response.isSuccess()) {
                return ResponseEntity.badRequest().body("Gagal login: " + response.getMessage());
            }
            return ResponseEntity.ok("Sukses login: " + response.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Gagal login: Silakan coba lagi nanti.");
        }
    }
}
