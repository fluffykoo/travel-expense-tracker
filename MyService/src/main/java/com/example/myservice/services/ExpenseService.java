package com.example.myservice.services;

import com.example.myservice.entities.Expense;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {
    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public Expense getExpenseById(int id) {
        return expenses.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Expense> getExpensesByDestinationId(int destinationId) {
        return expenses.stream()
                .filter(e -> e.getDestinationId() == destinationId)
                .collect(Collectors.toList());
    }

    public double getTotalByDestinationId(int destinationId) {
        return expenses.stream()
                .filter(e -> e.getDestinationId() == destinationId)
                .mapToDouble(Expense::getMontant)
                .sum();
    }

    public void deleteExpense(int id) {
        expenses.removeIf(e -> e.getId() == id);
    }
}
