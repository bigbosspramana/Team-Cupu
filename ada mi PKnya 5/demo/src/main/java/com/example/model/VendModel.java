package com.example.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TabelRegisterV")
public class VendModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_vendor;

    private String emailv;
    private String passwordv;
    private String confirmPasswordv;
    private String namaVendorv;
    private String alamatv;
    private String nomorTeleponv;
    private String instagramv;
    private String tiktokv;
    private String facebookv;
    private String role = "vendor";
    
    public VendModel() {
    }

    public VendModel(String emailv, String passwordv, String confirmPasswordv, String namaVendorv, String alamatv,
            String nomorTeleponv, String instagramv, String tiktokv, String facebookv, String role) {
        this.id_vendor = UUID.randomUUID(); // Generate UUID
        this.emailv = emailv;
        this.passwordv = passwordv;
        this.confirmPasswordv = confirmPasswordv;
        this.namaVendorv = namaVendorv;
        this.alamatv = alamatv;
        this.nomorTeleponv = nomorTeleponv;
        this.instagramv = instagramv;
        this.tiktokv = tiktokv;
        this.facebookv = facebookv;
        this.role = role;
    }

    public UUID getId_vendor() {
        return id_vendor;
    }

    public void setId_vendor(UUID id_vendor) {
        this.id_vendor = id_vendor;
    }

    public String getEmailv() {
        return emailv;
    }

    public void setEmailv(String emailv) {
        this.emailv = emailv;
    }

    public String getPasswordv() {
        return passwordv;
    }

    public void setPasswordv(String passwordv) {
        this.passwordv = passwordv;
    }

    public String getConfirmPasswordv() {
        return confirmPasswordv;
    }

    public void setConfirmPasswordv(String confirmPasswordv) {
        this.confirmPasswordv = confirmPasswordv;
    }

    public String getNamaVendorv() {
        return namaVendorv;
    }

    public void setNamaVendorv(String namaVendorv) {
        this.namaVendorv = namaVendorv;
    }

    public String getAlamatv() {
        return alamatv;
    }

    public void setAlamatv(String alamatv) {
        this.alamatv = alamatv;
    }

    public String getNomorTeleponv() {
        return nomorTeleponv;
    }

    public void setNomorTeleponv(String nomorTeleponv) {
        this.nomorTeleponv = nomorTeleponv;
    }

    public String getInstagramv() {
        return instagramv;
    }

    public void setInstagramv(String instagramv) {
        this.instagramv = instagramv;
    }

    public String getTiktokv() {
        return tiktokv;
    }

    public void setTiktokv(String tiktokv) {
        this.tiktokv = tiktokv;
    }

    public String getFacebookv() {
        return facebookv;
    }

    public void setFacebookv(String facebookv) {
        this.facebookv = facebookv;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
