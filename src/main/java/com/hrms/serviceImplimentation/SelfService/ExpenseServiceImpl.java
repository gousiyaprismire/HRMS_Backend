package com.hrms.serviceImplimentation.SelfService;

import com.hrms.model.SelfService.Expense;
import com.hrms.repository.Selfservice.ExpenseRepository;
import com.hrms.service.SelfService.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl extends ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Expense submitExpense(Expense expense) {
        expense.setStatus("Pending");
        return repository.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Expense> getExpensesByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}

