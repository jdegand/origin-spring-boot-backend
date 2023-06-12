package com.example.demo.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MaritalStatusValidator.class)
public @interface ValidateMaritalStatus {
    public String message() default "Invalid marital status: Only 'married' or 'single' allowed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
