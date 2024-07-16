package com.example.sediciluglio.db.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String city;

    @OneToMany(mappedBy = "farm")
    @JsonIgnore
    private List<Farmer> farmers = new ArrayList<>();

    public Farm(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Farm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
    }
}
