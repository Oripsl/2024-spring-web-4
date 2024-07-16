package com.example.sediciluglio.web.dto;

public class FarmerDto {
    private String name;

    private String surname;

    private Integer age;

    private Integer farmId;

    public FarmerDto() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setFarmId(Integer farmId) {
        this.farmId = farmId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getFarmId() {
        return farmId;
    }
}
