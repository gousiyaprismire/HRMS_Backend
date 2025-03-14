package com.hrms.service.SelfService;



import com.hrms.model.SelfService.Expense;
import com.hrms.repository.Selfservice.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public abstract List<Expense> getAllExpenses();

    public abstract Expense getExpenseById(Long id);

    public Expense submitExpense(Expense expense) {
        expense.setStatus("Pending");
        return expenseRepository.save(expense);
    }

    public abstract void deleteExpense(Long id);

    public List<Expense> getExpensesByUser(Long userId) {
        return expenseRepository.findByUserId(userId);
    }
}

