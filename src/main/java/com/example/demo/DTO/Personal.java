package com.example.demo.DTO;

import com.example.demo.validation.ValidateMaritalStatus;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.PositiveOrZero;

public class Personal {

    @Min(18)
    @Max(85)
    public int age;

    @PositiveOrZero
    public int income;

    @ValidateMaritalStatus
    public String marital_status;

    public int getAge() {
        return age;
    }

    public int getIncome() {
        return income;
    }

    public String getMarital_status() {
        return marital_status;
    }
}
