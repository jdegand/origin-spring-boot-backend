package com.example.demo.DTO;

import jakarta.validation.Valid;

public class ApplicantData {
    @Valid
    public Personal personal;
    
    @Valid
    public House house;

    @Valid
    public Vehicle vehicle;

    @Valid
    // add validator here to check array has only true and false values ?
    // isValid could accept a List<String> and return if all values match true / false
    public Questions questions;
    
    public Personal getPersonal() {
        return personal;
    }
    public House getHouse() {
        return house;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public Questions getQuestions() {
        return questions;
    }
}
