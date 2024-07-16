package com.example.sediciluglio.web.controller;

import com.example.sediciluglio.db.entities.Farm;
import com.example.sediciluglio.db.entities.Farmer;
import com.example.sediciluglio.db.services.FarmService;
import com.example.sediciluglio.db.services.FarmerService;
import com.example.sediciluglio.web.dto.FarmerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmer")
public class FarmerController {
    @Autowired
    private FarmerService farmerService;

    @Autowired
    private FarmService farmService;


    @PostMapping("/addFakeFarmers")
    public void addFakeFarmers() {
        Farm farm = new Farm("Carlo", "Alberto");
        farmService.add(farm);

        FarmerDto farmer1 = new FarmerDto();
        farmer1.setName("John");
        farmer1.setSurname("Doe");
        farmer1.setAge(30);
        farmer1.setFarmId(farm.getId());

        FarmerDto farmer2 = new FarmerDto();
        farmer2.setName("Jane");
        farmer2.setSurname("Smith");
        farmer2.setAge(25);
        farmer2.setFarmId(farm.getId());

        FarmerDto farmer3 = new FarmerDto();
        farmer3.setName("Bob");
        farmer3.setSurname("Brown");
        farmer3.setAge(40);
        farmer3.setFarmId(farm.getId());

        farmerService.add(farmer1);
        farmerService.add(farmer2);
        farmerService.add(farmer3);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            Farmer farmer = farmerService.getById(id);
            return ResponseEntity.ok(farmer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("")
    private ResponseEntity<List<Farmer>> getAll() {
        return ResponseEntity.ok(farmerService.getAll());
    }

    @PostMapping("")
    private ResponseEntity<?> create(@RequestBody FarmerDto farmerDto) {
        try {
            Farmer farmer = farmerService.add(farmerDto);
            return ResponseEntity.ok(farmer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> update(@RequestBody FarmerDto farmerDto, @PathVariable Integer id) {
        try {
            Farmer farmer = farmerService.update(id, farmerDto);
            return ResponseEntity.ok(farmer);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            farmerService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
