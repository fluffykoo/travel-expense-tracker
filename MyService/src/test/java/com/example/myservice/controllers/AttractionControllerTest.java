package com.example.myservice.controllers;

import com.example.myservice.entities.Attraction;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class AttractionControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testAddAttraction() throws Exception {
        Attraction attraction = new Attraction(1, "Tour de Tokyo", "Grande tour", 1);
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/attractions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(attraction)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAttractions() throws Exception {
        mockMvc.perform(get("/attractions"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAttractionById() throws Exception {
        mockMvc.perform(get("/attractions/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAttractionsByCity() throws Exception {
        mockMvc.perform(get("/attractions/city/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteAttraction() throws Exception {
        mockMvc.perform(delete("/attractions/1"))
                .andExpect(status().isOk());
    }
}
