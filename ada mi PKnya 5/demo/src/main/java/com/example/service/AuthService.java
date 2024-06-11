package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.data.repository.WisatRepository;
import com.example.data.repository.VendRepository;
import com.example.model.WisatModel;
import com.example.model.VendModel;

@Service
public class AuthService {

    @Autowired
    private WisatRepository wisatRepository;

    @Autowired
    private VendRepository vendRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponse registerWisatawan(WisatModel signupRequest) {
        if (wisatRepository.existsByEmailw(signupRequest.getEmailw())) {
            return new AuthResponse(false, "Email telah digunakan");
        }

        if (!signupRequest.getPasswordw().equals(signupRequest.getKonfirmasipasswordw())) {
            return new AuthResponse(false, "Kata sandi dan konfirmasi kata sandi tidak sama");
        }

        WisatModel wisatawan = new WisatModel(
            signupRequest.getEmailw(),
            passwordEncoder.encode(signupRequest.getPasswordw()),
            signupRequest.getKonfirmasipasswordw(),
            signupRequest.getNamaLengkapw(),
            signupRequest.getJenisKelaminw(),
            signupRequest.getTanggalLahirw(),
            signupRequest.getKotaw(),
            signupRequest.getNomorTeleponw()
        );
        wisatRepository.save(wisatawan);

        return new AuthResponse(true, "Sukses registrasi sebagai Wisatawan");
    }

    public AuthResponse registerVendor(VendModel signupRequest) {
        if (vendRepository.existsByEmailv(signupRequest.getEmailv())) {
            return new AuthResponse(false, "Email telah digunakan");
        }

        if (!signupRequest.getPasswordv().equals(signupRequest.getConfirmPasswordv())) {
            return new AuthResponse(false, "Kata sandi dan konfirmasi kata sandi tidak sama");
        }

        VendModel vendor = new VendModel(
            signupRequest.getEmailv(),
            passwordEncoder.encode(signupRequest.getPasswordv()),
            signupRequest.getConfirmPasswordv(),
            signupRequest.getNamaVendorv(),
            signupRequest.getAlamatv(),
            signupRequest.getNomorTeleponv(),
            signupRequest.getInstagramv(),
            signupRequest.getTiktokv(),
            signupRequest.getFacebookv(),
            signupRequest.getRole()
        );
        vendRepository.save(vendor);

        return new AuthResponse(true, "Sukses registrasi sebagai Vendor");
    }

    public AuthResponse loginUser(LoginRequest loginRequest) {
        WisatModel wisatawan = wisatRepository.findByEmailw(loginRequest.getEmail());
        VendModel vendor = vendRepository.findByEmailv(loginRequest.getEmail());

        if (wisatawan != null && passwordEncoder.matches(loginRequest.getPassword(), wisatawan.getPasswordw())) {
            return new AuthResponse(true, "Sukses login sebagai Wisatawan");
        }

        if (vendor != null && passwordEncoder.matches(loginRequest.getPassword(), vendor.getPasswordv())) {
            return new AuthResponse(true, "Sukses login sebagai Vendor");
        }

        return new AuthResponse(false, "Email atau Kata Sandi salah");
    }
}
