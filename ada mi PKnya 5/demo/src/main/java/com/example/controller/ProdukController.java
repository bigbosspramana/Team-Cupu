package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.data.repository.ProdukRepository;
import com.example.model.ProdukModel;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3007")
@RestController
@RequestMapping("/api")
public class ProdukController {

    @Autowired
    private ProdukRepository produkRepository;

    // Create operation
    @PostMapping("/produk")
    public ResponseEntity<ProdukModel> addData(@RequestBody ProdukModel newData) {
        ProdukModel savedData = produkRepository.save(newData);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    // Read operation (get all data)
    @GetMapping("/produk")
    public ResponseEntity<List<ProdukModel>> getAllData() {
        List<ProdukModel> dataList = produkRepository.findAll();
        return new ResponseEntity<>(dataList, HttpStatus.OK);
    }

    // Read operation (get data by ID)
    @GetMapping("/produk/{id}")
    public ResponseEntity<ProdukModel> getDataById(@PathVariable Long id) {
        ProdukModel data = produkRepository.findById(id)
                .orElse(null);
        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update operation
    @PutMapping("/produk/{id}")
    public ResponseEntity<ProdukModel> updateDataById(@PathVariable Long id, @RequestBody ProdukModel newData) {
        return produkRepository.findById(id)
        .map(existingProduk -> {
            existingProduk.setId_produk(newData.getId_produk());
            existingProduk.setTanggalp(newData.getTanggalp());
            existingProduk.setLokasi(newData.getLokasi());
            existingProduk.setHarga(newData.getHarga());
            existingProduk.setFoto(newData.getFoto());
            existingProduk.setKategori(newData.getKategori());
            existingProduk.setDeskripsi(newData.getDeskripsi());

            ProdukModel updatedData = produkRepository.save(existingProduk);
            return ResponseEntity.ok().body(updatedData);
        })
        .orElse(ResponseEntity.notFound().build());
}

    // Delete operation
    @DeleteMapping("/produk/{id}")
    public ResponseEntity<Void> deleteDataById(@PathVariable Long id) {
        produkRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
