package com.example.sediciluglio.db.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "farmer")
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    private Integer age;

    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

    public Farmer(String name, String surname, Integer age, Farm farm) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.farm = farm;
    }

    public Farmer() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}
