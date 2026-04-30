package com.example.myservice.controllers;

import com.example.myservice.entities.Destination;
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
public class DestinationControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testAddDestination() throws Exception {
        Destination destination = new Destination(1, "Japon", "A_VISITER");
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/destinations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(destination)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetDestinations() throws Exception {
        mockMvc.perform(get("/destinations"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetDestinationById() throws Exception {
        mockMvc.perform(get("/destinations/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateStatut() throws Exception {
        mockMvc.perform(put("/destinations/1")
                .param("statut", "VISITE"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteDestination() throws Exception {
        mockMvc.perform(delete("/destinations/1"))
                .andExpect(status().isOk());
    }
}
