package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.data.repository.AdminRepository;
import com.example.model.AdminModel;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3007")
@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    // Create operation
    @PostMapping("/admin")
    public ResponseEntity<AdminModel> addData(@RequestBody AdminModel newData) {
        AdminModel savedData = adminRepository.save(newData);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    // Read operation (get all data)
    @GetMapping("/admin")
    public ResponseEntity<List<AdminModel>> getAllData() {
        List<AdminModel> dataList = adminRepository.findAll();
        return new ResponseEntity<>(dataList, HttpStatus.OK);
    }

    // Read operation (get data by ID)
    @GetMapping("/admin/{id}")
    public ResponseEntity<AdminModel> getDataById(@PathVariable Long id) {
        AdminModel data = adminRepository.findById(id)
                .orElse(null);
        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update operation
    @PutMapping("/admin/{id}")
    public ResponseEntity<AdminModel> updateDataById(@PathVariable Long id, @RequestBody AdminModel newData) {
        return adminRepository.findById(id)
        .map(existingAdmin -> {
            existingAdmin.setID_Admin(newData.getID_Admin());
            existingAdmin.setEmail(newData.getEmail());
            existingAdmin.setPassword(newData.getPassword());
            existingAdmin.setNama_a(newData.getNama_a());

            AdminModel updatedData = adminRepository.save(existingAdmin);
            return ResponseEntity.ok().body(updatedData);
        })
        .orElse(ResponseEntity.notFound().build());
}

    // Delete operation
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> deleteDataById(@PathVariable Long id) {
        adminRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
