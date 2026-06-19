package com.example.expenseservice.services;

import com.example.expenseservice.entities.Expense;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExpenseServiceTest {

    @Autowired
    private ExpenseService service;

    @Test
    public void testAddAndGetExpenses() {
        service.addExpense(new Expense(0, 150.0, "HOTEL", "Hotel Tokyo", 1));
        assertFalse(service.getExpenses().isEmpty());
    }

    @Test
    public void testGetExpenseById() {
        service.addExpense(new Expense(0, 150.0, "HOTEL", "Hotel Tokyo", 1));
        Expense e = service.getExpenses().get(0);
        assertNotNull(service.getExpenseById(e.getId()));
    }

    @Test
    public void testGetExpenseByIdNotFound() {
        assertNull(service.getExpenseById(9999));
    }

    @Test
    public void testGetExpensesByDestinationId() {
        service.addExpense(new Expense(0, 150.0, "HOTEL", "Hotel Tokyo", 2));
        service.addExpense(new Expense(0, 50.0, "TRANSPORT", "Metro", 2));
        assertTrue(service.getExpensesByDestinationId(2).size() >= 2);
    }

    @Test
    public void testGetTotalByDestinationId() {
        service.addExpense(new Expense(0, 150.0, "HOTEL", "Hotel Tokyo", 3));
        service.addExpense(new Expense(0, 50.0, "TRANSPORT", "Metro", 3));
        assertEquals(200.0, service.getTotalByDestinationId(3));
    }

    @Test
    public void testDeleteExpense() {
        service.addExpense(new Expense(0, 150.0, "HOTEL", "Hotel Tokyo", 1));
        Expense e = service.getExpenses().get(0);
        service.deleteExpense(e.getId());
        assertNull(service.getExpenseById(e.getId()));
    }
}
