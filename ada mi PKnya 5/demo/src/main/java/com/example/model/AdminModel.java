package com.example.model;

// import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class AdminModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_Admin", columnDefinition = "VARCHAR(255)", nullable = false)
    private int id_admin;

    @Column(name = "Email", columnDefinition = "VARCHAR(255)")
    private String email;

    @Column(name = "Password", columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "Nama_Admin", columnDefinition = "VARCHAR(255)")
    private String nama_a;

    public AdminModel(int id_admin, String email, String password, String nama_a) {
        this.id_admin = id_admin;
        this.email = email;
        this.password = password;
        this.nama_a = nama_a;
    }

    public AdminModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getID_Admin() {
        return id_admin;
    }

    public void setID_Admin(int id_admin) {
        this.id_admin = id_admin;
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

    public String getNama_a() {
        return nama_a;
    }

    public void setNama_a(String nama_a) {
        this.nama_a = nama_a;
    }
}
