package com.example.demo.validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MaritalStatusValidator implements ConstraintValidator<ValidateMaritalStatus, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // have to check case in frontend / handle here
        List<String> maritalStatusTypes = Arrays.asList("married", "single");
        return maritalStatusTypes.contains(value);
    }
    
}
