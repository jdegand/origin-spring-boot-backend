package com.example.demo.DTO;

import com.example.demo.validation.ValidateOwnershipStatus;

import jakarta.validation.constraints.PositiveOrZero;

public class House {
   
    @ValidateOwnershipStatus
    public String ownership_status;

    @PositiveOrZero
    public int dependents;

    public String getOwnership_status() {
        return ownership_status;
    }
    public int getDependents() {
        return dependents;
    }
}
