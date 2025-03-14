package com.hrms.controller.SelfService;

import com.hrms.model.SelfService.Expense;
import com.hrms.service.SelfService.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/self/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense submitExpense(@RequestBody Expense expense) {
        return expenseService.submitExpense(expense);
    }

    @GetMapping("/{userId}")
    public List<Expense> getExpensesByUser(@PathVariable Long userId) {
        return expenseService.getExpensesByUser(userId);
    }
}

