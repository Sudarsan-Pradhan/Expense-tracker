package com.example.demo.service;

import com.example.demo.entity.ExpenseEntity;
import com.example.demo.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseEntity addExpense(ExpenseEntity expense) {
        return expenseRepository.save(expense);
    }

    public List<ExpenseEntity> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public Optional<ExpenseEntity> getExpenseById(@PathVariable Long id) {
        return expenseRepository.findById(id);
    }
    
    public ExpenseEntity updateExpense(Long id, ExpenseEntity expenseDetails) {
        return expenseRepository.findById(id)
            .map(expense -> {
                expense.setDescription(expenseDetails.getDescription());
                expense.setAmount(expenseDetails.getAmount());
                expense.setDate(expenseDetails.getDate());
                return expenseRepository.save(expense);
            })
            .orElseThrow(() -> new NoSuchElementException("Expense not found with id: " + id));
    }
    
    public void deleteExpense(Long id) {
        if (!expenseRepository.existsById(id)) {
            throw new NoSuchElementException("Expense not found with id: " + id);
        }
        expenseRepository.deleteById(id);
    }

}
