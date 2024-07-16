package com.example.sediciluglio.db.services;

import com.example.sediciluglio.db.entities.Farm;
import com.example.sediciluglio.db.entities.Farmer;
import com.example.sediciluglio.db.repos.FarmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FarmService {

    @Autowired
    private FarmRepo farmRepo;

    public List<Farm> getAllFarmsWithoutFarmers() {
        return farmRepo.findAll().stream()
                .filter(farm -> farm.getFarmers().isEmpty())
                .collect(Collectors.toList());
    }

    public List<Farmer> getFarmFarmers(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        Optional<Farm> optionalFarm = farmRepo.findById(id);
        if (optionalFarm.isEmpty()) {
            throw new IllegalArgumentException("Farm with id: " + id + " was not found");
        }

        return optionalFarm.get().getFarmers();
    }

    public Farm addFarm(Farm farm) {
        if (farm == null) {
            throw new IllegalArgumentException("Farm cannot be null");
        }

        return farmRepo.save(farm);
    }

    public Farm updateFarm(Integer id, Farm updatedFarm) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if (updatedFarm == null) {
            throw new IllegalArgumentException("Updated farm cannot be null");
        }

        Optional<Farm> optionalFarm = farmRepo.findById(id);
        if (optionalFarm.isEmpty()) {
            throw new IllegalArgumentException("Farm with id: " + id + " was not found");
        }

        Farm farm = optionalFarm.get();
        farm.setName(updatedFarm.getName() != null ? updatedFarm.getName() : farm.getName());
        farm.setCity(updatedFarm.getCity() != null ? updatedFarm.getCity() : farm.getCity());

        return farmRepo.save(farm);
    }

}