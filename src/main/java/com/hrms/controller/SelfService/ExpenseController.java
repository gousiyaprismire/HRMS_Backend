package com.hrms.controller.SelfService;

import com.hrms.model.SelfService.Expense;
import com.hrms.repository.Selfservice.ExpenseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateExpenseStatus(@PathVariable Long id, @RequestBody Map<String, String> statusMap) {
        String status = statusMap.get("status");

        if (status == null) {
            return ResponseEntity.badRequest().body("Status is required.");
        }

        Optional<Expense> expenseOpt = expenseRepository.findById(id);

        if (expenseOpt.isPresent()) {
            Expense expense = expenseOpt.get();
            expense.setStatus(status);
            expenseRepository.save(expense);
            return ResponseEntity.ok("Expense status updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense not found");
        }
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<Expense> updateExpenseStatus(@PathVariable Long id, @RequestBody String status) {
        return expenseRepository.findById(id).map(expense -> {
            expense.setStatus(status);
            return ResponseEntity.ok(expenseRepository.save(expense));
        }).orElse(ResponseEntity.notFound().build());
    }

}
