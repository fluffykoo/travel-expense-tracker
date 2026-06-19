package com.example.expenseservice.controllers;

import com.example.expenseservice.entities.Expense;
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
public class ExpenseControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testAddExpense() throws Exception {
        Expense expense = new Expense(1, 150.0, "HOTEL", "Hotel Tokyo", 1);
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/expenses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(expense)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetExpenses() throws Exception {
        mockMvc.perform(get("/expenses"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetExpenseById() throws Exception {
        mockMvc.perform(get("/expenses/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetExpensesByDestination() throws Exception {
        mockMvc.perform(get("/expenses/destination/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTotalByDestination() throws Exception {
        mockMvc.perform(get("/expenses/destination/1/total"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteExpense() throws Exception {
        mockMvc.perform(delete("/expenses/1"))
                .andExpect(status().isOk());
    }
}
