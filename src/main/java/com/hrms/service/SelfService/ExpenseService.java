package com.hrms.service.SelfService;


import com.hrms.model.SelfService.Expense;
import com.hrms.repository.Selfservice.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;


    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }


    public Expense addExpense(Expense expense) {
        expense.setStatus("Pending"); 
        return expenseRepository.save(expense);
    }
}


