package com.example.sediciluglio.db.services;

import com.example.sediciluglio.db.entities.Farm;
import com.example.sediciluglio.db.entities.Farmer;
import com.example.sediciluglio.db.repos.FarmRepo;
import com.example.sediciluglio.db.repos.FarmerRepo;
import com.example.sediciluglio.web.dto.FarmerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepo farmerRepo;
    @Autowired
    private FarmRepo farmRepo;

    public Farmer create(FarmerDto farmerDto) {
        Optional<Farm> farmOptional = farmRepo.findById(farmerDto.getFarmId());
        if (farmOptional.isEmpty()) {
            throw new IllegalArgumentException("Farm with id: " + farmerDto.getFarmId() + " was not found");
        }
        Farmer farmer = new Farmer();

        farmer.setName(farmerDto.getName());
        farmer.setSurname(farmerDto.getSurname());
        farmer.setAge(farmerDto.getAge());
        farmer.setFarm(farmOptional.get());

        return farmerRepo.save(farmer);
    }

    public Farmer getById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        Optional<Farmer> optionalFarmer = farmerRepo.findById(id);
        if (optionalFarmer.isEmpty()) {
            throw new IllegalArgumentException("Farmer with id: " + id + " was not found");
        }

        return optionalFarmer.get();
    }

    public List<Farmer> getAll() {
        return farmerRepo.findAll();
    }

    public Farmer update(Integer id, FarmerDto farmerDto) {
        if (id == null || farmerDto == null) {
            throw new IllegalArgumentException("Id or Dto cannot be null");
        }

        Optional<Farmer> optionalFarmer = farmerRepo.findById(id);
        if (optionalFarmer.isEmpty()) {
            throw new IllegalArgumentException("Farmer with id: " + id + " was not found");
        }

        Farmer foundFarmer = optionalFarmer.get();

        if (farmerDto.getFarmId() != null) {
            Optional<Farm> farmOptional = farmRepo.findById(farmerDto.getFarmId());
            if (farmOptional.isEmpty()) {
                throw new IllegalArgumentException("Farm with id: " + farmerDto.getFarmId() + " was not found");
            }
            foundFarmer.setFarm(farmOptional.get());
        }

        foundFarmer.setName(farmerDto.getName() != null ? farmerDto.getName() : foundFarmer.getName());
        foundFarmer.setSurname(farmerDto.getSurname() != null ? farmerDto.getSurname() : foundFarmer.getSurname());
        foundFarmer.setAge(farmerDto.getAge() != null ? farmerDto.getAge() : foundFarmer.getAge());

        return farmerRepo.save(foundFarmer);
    }

    public void delete(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        Optional<Farmer> optionalFarmer = farmerRepo.findById(id);
        if (optionalFarmer.isEmpty()) {
            throw new IllegalArgumentException("Farmer with id: " + id + " was not found");
        }

        farmerRepo.delete(optionalFarmer.get());
    }
}
