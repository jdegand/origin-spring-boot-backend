package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ApplicantData;

import com.example.demo.service.ScoreService;

import jakarta.validation.Valid;

@RestController
public class ScoreController {

  @Autowired
  private ScoreService scoreService;

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping(path = "/api/score", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HashMap<String,String> getScore(@RequestBody @Valid ApplicantData applicantData) {
    return scoreService.getScore(applicantData);
  }

}
