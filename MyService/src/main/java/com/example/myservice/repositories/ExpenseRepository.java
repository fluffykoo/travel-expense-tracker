package com.example.myservice.repositories;

import com.example.myservice.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    List<Expense> findByDestinationId(int destinationId);
}
