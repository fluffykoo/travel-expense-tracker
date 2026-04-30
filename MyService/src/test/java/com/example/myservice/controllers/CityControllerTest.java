package com.example.myservice.controllers;

import com.example.myservice.entities.City;
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
public class CityControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testAddCity() throws Exception {
        City city = new City(1, "Tokyo", 1);
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/cities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(city)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCities() throws Exception {
        mockMvc.perform(get("/cities"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCityById() throws Exception {
        mockMvc.perform(get("/cities/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCitiesByDestination() throws Exception {
        mockMvc.perform(get("/cities/destination/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteCity() throws Exception {
        mockMvc.perform(delete("/cities/1"))
                .andExpect(status().isOk());
    }
}
