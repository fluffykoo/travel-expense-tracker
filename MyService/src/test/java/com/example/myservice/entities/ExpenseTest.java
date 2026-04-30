package com.example.myservice.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpenseTest {

    @Test
    public void testExpenseConstructor() {
        Expense expense = new Expense(1, 150.0, "HOTEL", "Hotel Tokyo", 1);
        assertEquals(1, expense.getId());
        assertEquals(150.0, expense.getMontant());
        assertEquals("HOTEL", expense.getCategorie());
        assertEquals("Hotel Tokyo", expense.getDescription());
        assertEquals(1, expense.getDestinationId());
    }

    @Test
    public void testExpenseSetters() {
        Expense expense = new Expense(1, 150.0, "HOTEL", "Hotel Tokyo", 1);
        expense.setMontant(200.0);
        expense.setCategorie("TRANSPORT");
        assertEquals(200.0, expense.getMontant());
        assertEquals("TRANSPORT", expense.getCategorie());
    }
}
