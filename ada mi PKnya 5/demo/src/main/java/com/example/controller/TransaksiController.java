package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.data.repository.TransaksiRepository;
import com.example.model.TransaksiModel;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3007")
@RestController
@RequestMapping("/api")
public class TransaksiController {

    @Autowired
    private TransaksiRepository transaksiRepository;

    // Create operation
    @PostMapping("/transaksi")
    public ResponseEntity<TransaksiModel> addData(@RequestBody TransaksiModel newData) {
        TransaksiModel savedData = transaksiRepository.save(newData);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    // Read operation (get all data)
    @GetMapping("/transaksi")
    public ResponseEntity<List<TransaksiModel>> getAllData() {
        List<TransaksiModel> dataList = transaksiRepository.findAll();
        return new ResponseEntity<>(dataList, HttpStatus.OK);
    }

    // Read operation (get data by ID)
    @GetMapping("/transaksi/{id}")
    public ResponseEntity<TransaksiModel> getDataById(@PathVariable Long id) {
        TransaksiModel data = transaksiRepository.findById(id)
                .orElse(null);
        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update operation
    @PutMapping("/transaksi/{id}")
    public ResponseEntity<TransaksiModel> updateDataById(@PathVariable Long id, @RequestBody TransaksiModel newData) {
        return transaksiRepository.findById(id)
                .map(existingTransaksi -> {
                    existingTransaksi.setId_transaksi(newData.getId_transaksi());
                    existingTransaksi.setId_produk(newData.getId_produk());
                    existingTransaksi.setTotalharga(newData.getTotalharga());

                    TransaksiModel updatedData = transaksiRepository.save(existingTransaksi);
                    return ResponseEntity.ok().body(updatedData);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    // Delete operation
    @DeleteMapping("/transaksi/{id}")
    public ResponseEntity<Void> deleteDataById(@PathVariable Long id) {
        transaksiRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
