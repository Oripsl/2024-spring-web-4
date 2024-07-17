package com.example.sediciluglio.web.controller;

import com.example.sediciluglio.db.entities.Farm;
import com.example.sediciluglio.db.entities.Farmer;
import com.example.sediciluglio.db.services.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmController {

    @Autowired
    private FarmService farmService;

    @GetMapping("/withoutFarmers")
    public ResponseEntity<List<Farm>> getAllFarmsWithoutFarmers() {
        return ResponseEntity.ok(farmService.getAllFarmsWithoutFarmers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Farmer>> getAllFarmFarmers(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(farmService.getFarmers(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Farm> addFarm(@RequestBody Farm farm) {
        try {
            return ResponseEntity.ok(farmService.add(farm));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farm> updateFarm(@PathVariable Integer id, @RequestBody Farm updatedFarm) {
        try {
            return ResponseEntity.ok(farmService.update(id, updatedFarm));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
