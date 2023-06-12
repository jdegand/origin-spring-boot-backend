package com.example.demo.service;

import java.util.HashMap;

import com.example.demo.DTO.ApplicantData;

public interface ScoreService {
    public HashMap<String,String> getScore(ApplicantData applicantData);
}
