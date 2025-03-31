package com.hrms.controller.SelfService;


import com.hrms.model.SelfService.Expense;
import com.hrms.repository.Selfservice.ExpenseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "http://localhost:3000")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }


    @PostMapping(consumes = "application/json")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        expense.setStatus("Pending");
        Expense savedExpense = expenseRepository.save(expense);
        return ResponseEntity.ok(savedExpense);
    }
}
