package com.example.expenseservice.controllers;

import com.example.expenseservice.entities.Expense;
import com.example.expenseservice.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @PostMapping("/expenses")
    public void addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
    }

    @GetMapping("/expenses")
    public List<Expense> getExpenses() {
        return expenseService.getExpenses();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable int id) {
        return expenseService.getExpenseById(id);
    }

    @GetMapping("/expenses/destination/{destinationId}")
    public List<Expense> getExpensesByDestination(@PathVariable int destinationId) {
        return expenseService.getExpensesByDestinationId(destinationId);
    }

    @GetMapping("/expenses/destination/{destinationId}/total")
    public double getTotalByDestination(@PathVariable int destinationId) {
        return expenseService.getTotalByDestinationId(destinationId);
    }

    @DeleteMapping("/expenses/{id}")
    public void deleteExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
    }
}
