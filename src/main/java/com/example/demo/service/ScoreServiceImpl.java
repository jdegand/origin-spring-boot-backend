package com.example.demo.service;

import java.util.Calendar;

import java.util.HashMap;

import com.example.demo.DTO.ApplicantData;

import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

  // Questions are saved as Strings
  private int getBaseScore(String[] array) {
    int count = 0;
    for (String b : array) {
      if (b.equals("true")) {
        count += 1;
      }
    }
    return count;
  }

  private String evaluateTotal(Integer total) {
    if (total >= 3) {
      return "responsible";
    } else if (total > 0 && total <= 2) {
      return "regular";
    } else {
      return "economic";
    }
  }

  @Override
  public HashMap<String, String> getScore(ApplicantData applicantData) {

    // could do something more complicated
    String[] questions = { applicantData.getQuestions().question1, applicantData.getQuestions().question2,
        applicantData.getQuestions().question3 };

    int BASE_SCORE = getBaseScore(questions);

    Calendar calendar = Calendar.getInstance();
    int YEAR = calendar.get(Calendar.YEAR) - 5;

    HashMap<String, Integer> RETURN_OBJECT = new HashMap<String, Integer>();
    RETURN_OBJECT.put("auto", BASE_SCORE);
    RETURN_OBJECT.put("disability", BASE_SCORE);
    RETURN_OBJECT.put("home", BASE_SCORE);
    RETURN_OBJECT.put("life", BASE_SCORE);

    if (applicantData.getPersonal().age < 30) {
      RETURN_OBJECT.put("auto", RETURN_OBJECT.get("auto") - 2);
      RETURN_OBJECT.put("disability", RETURN_OBJECT.get("disability") - 2);
      RETURN_OBJECT.put("home", RETURN_OBJECT.get("home") - 2);
      RETURN_OBJECT.put("life", RETURN_OBJECT.get("life") - 2);
    }
    if (applicantData.getPersonal().age > 30 && applicantData.getPersonal().age < 40) {
      RETURN_OBJECT.put("auto", RETURN_OBJECT.get("auto") - 1);
      RETURN_OBJECT.put("disability", RETURN_OBJECT.get("disability") - 1);
      RETURN_OBJECT.put("home", RETURN_OBJECT.get("home") - 1);
      RETURN_OBJECT.put("life", RETURN_OBJECT.get("life") - 1);
    }
    if (applicantData.getPersonal().income > 200000) {
      RETURN_OBJECT.put("auto", RETURN_OBJECT.get("auto") - 1);
      RETURN_OBJECT.put("disability", RETURN_OBJECT.get("disability") - 1);
      RETURN_OBJECT.put("home", RETURN_OBJECT.get("home") - 1);
      RETURN_OBJECT.put("life", RETURN_OBJECT.get("life") - 1);
    }
    if (applicantData.getHouse().ownership_status != null
        && applicantData.getHouse().ownership_status.equals("mortgaged")) {
      RETURN_OBJECT.put("disability", RETURN_OBJECT.get("disability") + 1);
      RETURN_OBJECT.put("home", RETURN_OBJECT.get("home") + 1);
    }
    if (applicantData.getHouse().dependents > 0) {
      RETURN_OBJECT.put("disability", RETURN_OBJECT.get("disability") + 1);
      RETURN_OBJECT.put("life", RETURN_OBJECT.get("life") + 1);
    }
    if (applicantData.getPersonal().marital_status.equals("married")) {
      RETURN_OBJECT.put("life", RETURN_OBJECT.get("life") + 1);
      RETURN_OBJECT.put("disability", RETURN_OBJECT.get("disability") - 1);
    }
    if (applicantData.getVehicle().getYear() >= YEAR) {
      RETURN_OBJECT.put("auto", RETURN_OBJECT.get("auto") + 1);
    }

    return new HashMap<String, String>() {
      {
        put("auto", applicantData.getVehicle() == null ? "ineligible" : evaluateTotal(RETURN_OBJECT.get("auto")));
        put("disability",
            applicantData.getPersonal().income == 0 ? "ineligible" : evaluateTotal(RETURN_OBJECT.get("disability")));
        put("home", applicantData.getHouse() == null ? "ineligible" : evaluateTotal(RETURN_OBJECT.get("home")));
        put("life", evaluateTotal(RETURN_OBJECT.get("life")));
      }
    };

  }

}
