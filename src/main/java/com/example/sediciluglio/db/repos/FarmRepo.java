package com.example.sediciluglio.db.repos;

import com.example.sediciluglio.db.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepo extends JpaRepository<Farm, Integer> {
}
