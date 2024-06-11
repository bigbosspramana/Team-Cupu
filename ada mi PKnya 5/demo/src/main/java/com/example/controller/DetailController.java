package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.data.repository.Detail_Repository;
import com.example.model.Detail_transaksi_model;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3007")
@RestController
@RequestMapping("/api")
public class DetailController {

    @Autowired
    private Detail_Repository detailRepository;

    // Create operation
    @PostMapping("/detail")
    public ResponseEntity<Detail_transaksi_model> addData(@RequestBody Detail_transaksi_model newData) {
        Detail_transaksi_model savedData = detailRepository.save(newData);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    // Read operation (get all data)
    @GetMapping("/detail")
    public ResponseEntity<List<Detail_transaksi_model>> getAllData() {
        List<Detail_transaksi_model> dataList = detailRepository.findAll();
        return new ResponseEntity<>(dataList, HttpStatus.OK);
    }

    // Read operation (get data by ID)
    @GetMapping("/detail/{id}")
    public ResponseEntity<Detail_transaksi_model> getDataById(@PathVariable Long id) {
        Detail_transaksi_model data = detailRepository.findById(id)
                .orElse(null);
        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update operation
    @PutMapping("/detail/{id}")
    public ResponseEntity<Detail_transaksi_model> updateDataById(@PathVariable Long id, @RequestBody Detail_transaksi_model newData) {
        return detailRepository.findById(id)
                .map(existingData -> {
                    existingData.setId_transaksi(newData.getId_transaksi());
                    existingData.setId_wisatawan(newData.getId_wisatawan());
                    existingData.setTgl_transaksi(newData.getTgl_transaksi());
                    existingData.setMetodebayar(newData.getMetodebayar());
                    existingData.setStatus(newData.getStatus());
                    existingData.setDiskon(newData.getDiskon());
                    existingData.setTotalsetelah(newData.getTotalsetelah());
                    Detail_transaksi_model updatedData = detailRepository.save(existingData);
                    return ResponseEntity.ok().body(updatedData);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete operation
    @DeleteMapping("/detail/{id}")
    public ResponseEntity<Void> deleteDataById(@PathVariable Long id) {
        detailRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
