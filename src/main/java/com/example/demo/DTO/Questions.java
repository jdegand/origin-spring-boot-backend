package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;

public class Questions {
    public String question1;
    public String question2;
    public String question3;
    
    @NotBlank
    public String getQuestion1() {
        return question1;
    }

    @NotBlank
    public String getQuestion2() {
        return question2;
    }
    
    @NotBlank
    public String getQuestion3() {
        return question3;
    }
}
