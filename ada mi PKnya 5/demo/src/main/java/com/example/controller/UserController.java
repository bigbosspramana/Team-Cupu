package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.data.repository.UserRepository;
import com.example.model.UserModel;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3007")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Create operation
    @PostMapping("/user")
    public ResponseEntity<UserModel> addData(@RequestBody UserModel newData) {
        UserModel savedData = userRepository.save(newData);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    // Read operation (get all data)
    @GetMapping("/user")
    public ResponseEntity<List<UserModel>> getAllData() {
        List<UserModel> dataList = userRepository.findAll();
        return new ResponseEntity<>(dataList, HttpStatus.OK);
    }

    // Read operation (get data by ID)
    @GetMapping("/user/{id}")
    public ResponseEntity<UserModel> getDataById(@PathVariable Long id) {
        UserModel data = userRepository.findById(id)
                .orElse(null);
        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update operation
    @PutMapping("/user/{id}")
    public ResponseEntity<UserModel> updateDataById(@PathVariable Long id, @RequestBody UserModel newData) {
        return userRepository.findById(id)
        .map(existingUser -> {
            existingUser.setId_user(newData.getId_user());
            existingUser.setId_wisatawan(newData.getId_wisatawan());
            existingUser.setId_vendor(newData.getId_vendor());
            existingUser.setId_admin(newData.getId_admin());

            UserModel updatedData = userRepository.save(existingUser);
            return ResponseEntity.ok().body(updatedData);
        })
        .orElse(ResponseEntity.notFound().build());
}

    // Delete operation
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteDataById(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
