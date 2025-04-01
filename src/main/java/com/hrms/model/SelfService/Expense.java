package com.hrms.model.SelfService;

import jakarta.persistence.*;

@Entity
@Table(name = "expense_reimbursement")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_title", nullable = false)
    private String expenseTitle;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String status = "Pending";

    @Column(nullable = false)
    private Integer employeeId;

    @Lob
    private String receiptBase64;


    public Expense() {
    }


    public Expense(String expenseTitle, double amount, String receiptBase64, Integer employeeId) {
        this.expenseTitle = expenseTitle;
        this.amount = amount;
        this.receiptBase64 = receiptBase64;
        this.status = "Pending";
        this.employeeId = employeeId;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getExpenseTitle() { return expenseTitle; }
    public void setExpenseTitle(String expenseTitle) { this.expenseTitle = expenseTitle; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getEmployeeId() { return employeeId; }
    public void setEmployeeId(Integer employeeId) { this.employeeId = employeeId; }

    public String getReceiptBase64() { return receiptBase64; }
    public void setReceiptBase64(String receiptBase64) { this.receiptBase64 = receiptBase64; }
}
