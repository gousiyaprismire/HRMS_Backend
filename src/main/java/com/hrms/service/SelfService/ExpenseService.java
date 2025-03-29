package com.hrms.service.SelfService;


import com.hrms.model.SelfService.Expense;

import com.hrms.repository.Selfservice.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public List<Expense> getExpensesByEmployeeId(Long employeeId) {
        return expenseRepository.findByEmployeeId(employeeId);
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {
        Optional<Expense> existingExpense = expenseRepository.findById(id);
        if (existingExpense.isPresent()) {
            Expense expense = existingExpense.get();
            expense.setExpenseTitle(updatedExpense.getExpenseTitle());
            expense.setAmount(updatedExpense.getAmount());
            expense.setReceiptPath(updatedExpense.getReceiptPath());
            expense.setStatus(updatedExpense.getStatus());
            return expenseRepository.save(expense);
        }
        return null;
    }

    public boolean deleteExpense(Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

