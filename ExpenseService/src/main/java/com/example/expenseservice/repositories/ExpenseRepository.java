package com.example.expenseservice.repositories;

import com.example.expenseservice.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    List<Expense> findByDestinationId(int destinationId);
}
