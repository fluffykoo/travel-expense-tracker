package com.example.myservice.services;

import com.example.myservice.entities.Expense;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpenseServiceTest {

    @Test
    public void testAddAndGetExpenses() {
        ExpenseService service = new ExpenseService();
        service.addExpense(new Expense(1, 150.0, "HOTEL", "Hotel Tokyo", 1));
        assertEquals(1, service.getExpenses().size());
    }

    @Test
    public void testGetExpenseById() {
        ExpenseService service = new ExpenseService();
        service.addExpense(new Expense(1, 150.0, "HOTEL", "Hotel Tokyo", 1));
        assertNotNull(service.getExpenseById(1));
    }

    @Test
    public void testGetExpenseByIdNotFound() {
        ExpenseService service = new ExpenseService();
        assertNull(service.getExpenseById(99));
    }

    @Test
    public void testGetExpensesByDestinationId() {
        ExpenseService service = new ExpenseService();
        service.addExpense(new Expense(1, 150.0, "HOTEL", "Hotel Tokyo", 1));
        service.addExpense(new Expense(2, 50.0, "TRANSPORT", "Metro", 1));
        assertEquals(2, service.getExpensesByDestinationId(1).size());
    }

    @Test
    public void testGetTotalByDestinationId() {
        ExpenseService service = new ExpenseService();
        service.addExpense(new Expense(1, 150.0, "HOTEL", "Hotel Tokyo", 1));
        service.addExpense(new Expense(2, 50.0, "TRANSPORT", "Metro", 1));
        assertEquals(200.0, service.getTotalByDestinationId(1));
    }

    @Test
    public void testDeleteExpense() {
        ExpenseService service = new ExpenseService();
        service.addExpense(new Expense(1, 150.0, "HOTEL", "Hotel Tokyo", 1));
        service.deleteExpense(1);
        assertEquals(0, service.getExpenses().size());
    }
}
