package com.example.myservice.services;

import com.example.myservice.entities.Expense;
import com.example.myservice.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(int id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public List<Expense> getExpensesByDestinationId(int destinationId) {
        return expenseRepository.findByDestinationId(destinationId);
    }

    public double getTotalByDestinationId(int destinationId) {
        return expenseRepository.findByDestinationId(destinationId).stream()
                .mapToDouble(Expense::getMontant)
                .sum();
    }

    public void deleteExpense(int id) {
        expenseRepository.deleteById(id);
    }
}