package com.example.demo.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.ScoreService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ScoreController.class)
public class ScoreControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScoreService scoreService;

    @Test
    void postRequest() {

        // need setters to create new ApplicantData?

        try {
            mockMvc.perform(post("/api/score")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\r\n"
                            + "\"personal\": {\r\n    \"age\": 35,\r\n    \"income\": 0,\r\n    \"marital_status\": \"married\"\r\n  },\r\n  \"house\": {\r\n    \"ownership_status\": \"owned\",\r\n    \"dependents\": 2\r\n  },\r\n  \"vehicle\": {\r\n    \"year\": 2018\r\n  },\r\n  \"questions\": {\r\n    \"question1\": \"false\",\r\n    \"question2\": \"true\",\r\n    \"question3\": \"false\"\r\n"
                            + "}\r\n}"))
                    .andExpect(status().isOk());
                
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void postRequestFailsBecauseMinAge() {

        try {
            mockMvc.perform(post("/api/score")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\r\n"
                            + "\"personal\": {\r\n    \"age\": 15,\r\n    \"income\": 0,\r\n    \"marital_status\": \"married\"\r\n  },\r\n  \"house\": {\r\n    \"ownership_status\": \"owned\",\r\n    \"dependents\": 2\r\n  },\r\n  \"vehicle\": {\r\n    \"year\": 2018\r\n  },\r\n  \"questions\": {\r\n    \"question1\": \"false\",\r\n    \"question2\": \"true\",\r\n    \"question3\": \"false\"\r\n"
                            + "}\r\n}"))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void postRequestFailsNegativeIncome() {

        try {
            mockMvc.perform(post("/api/score")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\r\n"
                            + "\"personal\": {\r\n    \"age\": 35,\r\n    \"income\": -20000,\r\n    \"marital_status\": \"married\"\r\n  },\r\n  \"house\": {\r\n    \"ownership_status\": \"owned\",\r\n    \"dependents\": 2\r\n  },\r\n  \"vehicle\": {\r\n    \"year\": 2018\r\n  },\r\n  \"questions\": {\r\n    \"question1\": \"false\",\r\n    \"question2\": \"true\",\r\n    \"question3\": \"false\"\r\n"
                            + "}\r\n}"))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void postRequestFailsNegativeDependents() {

        try {
            mockMvc.perform(post("/api/score")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\r\n"
                            + "\"personal\": {\r\n    \"age\": 35,\r\n    \"income\": 0,\r\n    \"marital_status\": \"married\"\r\n  },\r\n  \"house\": {\r\n    \"ownership_status\": \"owned\",\r\n    \"dependents\": -2\r\n  },\r\n  \"vehicle\": {\r\n    \"year\": 2018\r\n  },\r\n  \"questions\": {\r\n    \"question1\": \"false\",\r\n    \"question2\": \"true\",\r\n    \"question3\": \"false\"\r\n"
                            + "}\r\n}"))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void postRequestFailsMaritalStatusNotPartOfEnum() {

        try {
            mockMvc.perform(post("/api/score")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\r\n"
                            + "\"personal\": {\r\n    \"age\": 35,\r\n    \"income\": 0,\r\n    \"marital_status\": \"mared\"\r\n  },\r\n  \"house\": {\r\n    \"ownership_status\": \"owned\",\r\n    \"dependents\": 2\r\n  },\r\n  \"vehicle\": {\r\n    \"year\": 2018\r\n  },\r\n  \"questions\": {\r\n    \"question1\": \"false\",\r\n    \"question2\": \"true\",\r\n    \"question3\": \"false\"\r\n"
                            + "}\r\n}"))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void postRequestFailsMinVehicleYear() {

        try {
            mockMvc.perform(post("/api/score")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\r\n"
                            + "\"personal\": {\r\n    \"age\": 35,\r\n    \"income\": 0,\r\n    \"marital_status\": \"married\"\r\n  },\r\n  \"house\": {\r\n    \"ownership_status\": \"owned\",\r\n    \"dependents\": 2\r\n  },\r\n  \"vehicle\": {\r\n    \"year\": 1900\r\n  },\r\n  \"questions\": {\r\n    \"question1\": \"false\",\r\n    \"question2\": \"true\",\r\n    \"question3\": \"false\"\r\n"
                            + "}\r\n}"))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void postRequestFailsMaxVehicleYear() {

        try {
            mockMvc.perform(post("/api/score")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\r\n"
                            + "\"personal\": {\r\n    \"age\": 35,\r\n    \"income\": 0,\r\n    \"marital_status\": \"married\"\r\n  },\r\n  \"house\": {\r\n    \"ownership_status\": \"owned\",\r\n    \"dependents\": 2\r\n  },\r\n  \"vehicle\": {\r\n    \"year\": 3000\r\n  },\r\n  \"questions\": {\r\n    \"question1\": \"false\",\r\n    \"question2\": \"true\",\r\n    \"question3\": \"false\"\r\n"
                            + "}\r\n}"))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void postRequestFailsBlankQuestion() {

        try {
            mockMvc.perform(post("/api/score")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\r\n"
                            + "\"personal\": {\r\n    \"age\": 35,\r\n    \"income\": 0,\r\n    \"marital_status\": \"married\"\r\n  },\r\n  \"house\": {\r\n    \"ownership_status\": \"owned\",\r\n    \"dependents\": 2\r\n  },\r\n  \"vehicle\": {\r\n    \"year\": 2000\r\n  },\r\n  \"questions\": {\r\n    \"question1\": \"\",\r\n    \"question2\": \"true\",\r\n    \"question3\": \"false\"\r\n"
                            + "}\r\n}"))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
