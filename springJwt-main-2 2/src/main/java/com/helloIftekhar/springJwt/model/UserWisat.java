package com.helloIftekhar.springJwt.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "userWisat")
public class UserWisat implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_wisatawan")
    private String id_wisatawan = UUID.randomUUID().toString();

    @Column(name = "email")
    private String emailw;

    @Column(name = "password")
    private String passwordw;

    @Column(name = "konfirmasi_password")
    private String konfirmasipasswordw;

    @Column(name = "nama_lengkap")
    private String namaLengkapw;

    @Enumerated(EnumType.STRING)
    @Column(name = "jenis_kelamin")
    private JenisKelamin jenisKelaminw;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggal_lahir")
    private Date tanggalLahirw;

    @Enumerated(EnumType.STRING)
    @Column(name = "kota")
    private Kota kotaw;

    @Column(name = "nomor_telepon")
    private String nomorTeleponw;

    @Enumerated(value = EnumType.STRING)
    private Role role = Role.WISATAWAN; // Default role WISATAWAN

    public UserWisat(String emailw, String passwordw, String konfirmasipasswordw, String namaLengkapw,
            JenisKelamin jenisKelaminw, Date tanggalLahirw, Kota kotaw, String nomorTeleponw) {
        this.emailw = emailw;
        this.passwordw = passwordw;
        this.konfirmasipasswordw = konfirmasipasswordw;
        this.namaLengkapw = namaLengkapw;
        this.jenisKelaminw = jenisKelaminw;
        this.tanggalLahirw = tanggalLahirw;
        this.kotaw = kotaw;
        this.nomorTeleponw = nomorTeleponw;
    }

    public UserWisat() {
    }

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public String getEmailw() {
        return emailw;
    }

    public void setEmailw(String emailw) {
        this.emailw = emailw;
    }

    public String getPasswordw() {
        return passwordw;
    }

    public void setPasswordw(String passwordw) {
        this.passwordw = passwordw;
    }

    public String getKonfirmasipasswordw() {
        return konfirmasipasswordw;
    }

    public void setKonfirmasipasswordw(String konfirmasipasswordw) {
        this.konfirmasipasswordw = konfirmasipasswordw;
    }

    public String getNamaLengkapw() {
        return namaLengkapw;
    }

    public void setNamaLengkapw(String namaLengkapw) {
        this.namaLengkapw = namaLengkapw;
    }

    public JenisKelamin getJenisKelaminw() {
        return jenisKelaminw;
    }

    public void setJenisKelaminw(JenisKelamin jenisKelaminw) {
        this.jenisKelaminw = jenisKelaminw;
    }

    public Date getTanggalLahirw() {
        return tanggalLahirw;
    }

    public void setTanggalLahirw(Date tanggalLahirw) {
        this.tanggalLahirw = tanggalLahirw;
    }

    public Kota getKotaw() {
        return kotaw;
    }

    public void setKotaw(Kota kotaw) {
        this.kotaw = kotaw;
    }

    public String getNomorTeleponw() {
        return nomorTeleponw;
    }

    public void setNomorTeleponw(String nomorTeleponw) {
        this.nomorTeleponw = nomorTeleponw;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public String getUsername() {
        return this.emailw;
    }

    @Override
    public String getPassword() {
        return this.passwordw;
    }

    public enum JenisKelamin {
        LAKI_LAKI, PEREMPUAN
    }

    public enum Kota {
        Jakarta, Bandung, Manokwari, Bali, Yogyakarta, Surabaya, Medan, Makassar, Malang, Lombok, Semarang, Palembang, Manado, Batam, Banjarmasin, Solo, Bogor, Denpasar, Padang, Balikpapan, Pontianak
    }

    public String getId_wisatawan() {
        return id_wisatawan;
    }

    public void setId_wisatawan(String id_wisatawan) {
        this.id_wisatawan = id_wisatawan;
    }
}
