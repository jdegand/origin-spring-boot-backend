package com.example.demo.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class Vehicle {

    // making max year dynamic more difficult ?

    @Min(1960)
    @Max(2024)
    public int year;

    public int getYear() {
        return year;
    }
}
