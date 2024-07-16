package com.example.sediciluglio.web.controller;

import com.example.sediciluglio.db.entities.Farm;
import com.example.sediciluglio.db.services.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farms")
public class FarmController {

    @Autowired
    private FarmService farmService;

    @GetMapping("/withoutFarmers")
    public ResponseEntity<?> getAllFarmsWithoutFarmers() {
        return ResponseEntity.ok(farmService.getAllFarmsWithoutFarmers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllFarmFarmers(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(farmService.getFarmers(id));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addFarm(@RequestBody Farm farm) {
        try {
            return ResponseEntity.ok(farmService.add(farm));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFarm(@PathVariable Integer id, @RequestBody Farm updatedFarm) {
        try {
            return ResponseEntity.ok(farmService.update(id, updatedFarm));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

}
