package com.example.demo.validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OwnershipStatusValidator implements ConstraintValidator<ValidateOwnershipStatus, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> ownershipStatusTypes = Arrays.asList("mortgaged", "owned", "none");
        return ownershipStatusTypes.contains(value);
    }
    
}
