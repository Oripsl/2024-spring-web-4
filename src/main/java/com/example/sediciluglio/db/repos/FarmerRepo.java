package com.example.sediciluglio.db.repos;

import com.example.sediciluglio.db.entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer, Integer> {
}
