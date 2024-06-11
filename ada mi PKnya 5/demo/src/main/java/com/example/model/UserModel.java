package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tabeluser")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_User", columnDefinition = "VARCHAR(255)")
    private int id_user;

    @Column(name = "ID_Wisatawan", columnDefinition = "VARCHAR(255)")
    private int id_wisatawan;

    @Column(name = "ID_Vendor", columnDefinition = "VARCHAR(255)")
    private int id_vendor;

    @Column(name = "ID_Admin", columnDefinition = "VARCHAR(255)")
    private int id_admin;

    @Column(name = "username", columnDefinition = "VARCHAR(255)", unique = true)
    private String username;

    @Column(name = "email", columnDefinition = "VARCHAR(255)", unique = true)
    private String email;

    @Column(name = "password", columnDefinition = "VARCHAR(255)")
    private String password;

    public UserModel(int id_user, int id_wisatawan, int id_vendor, int id_admin, String username, String email, String password) {
        this.id_user = id_user;
        this.id_wisatawan = id_wisatawan;
        this.id_vendor = id_vendor;
        this.id_admin = id_admin;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserModel() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_wisatawan() {
        return id_wisatawan;
    }

    public void setId_wisatawan(int id_wisatawan) {
        this.id_wisatawan = id_wisatawan;
    }

    public int getId_vendor() {
        return id_vendor;
    }

    public void setId_vendor(int id_vendor) {
        this.id_vendor = id_vendor;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
