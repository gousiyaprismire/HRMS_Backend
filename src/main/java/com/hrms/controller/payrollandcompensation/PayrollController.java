package com.hrms.controller.payrollandcompensation;

import com.hrms.model.payrollandcompensation.PayrollEntity;
import com.hrms.service.payrollandcompensation.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @PostMapping("/add")
    public PayrollEntity addPayroll(@RequestBody PayrollEntity payroll) {
        return payrollService.savePayroll(payroll);
    }

    @GetMapping("/all")
    public List<PayrollEntity> getAllPayrolls() {
        return payrollService.getAllPayrolls();
    }

    @GetMapping("/{empId}")
    public PayrollEntity getPayrollById(@PathVariable String empId) {
        return payrollService.getPayrollById(empId);
    }

    @GetMapping("/month/{month}/year/{year}")
    public List<PayrollEntity> getPayrollByMonthAndYear(@PathVariable String month, @PathVariable String year) {
        return payrollService.getPayrollByMonthAndYear(month, year);
    }

    @PutMapping("/update/{empId}")
    public PayrollEntity updatePayroll(@PathVariable String empId, @RequestBody PayrollEntity payroll) {
        return payrollService.updatePayroll(empId, payroll);
    }

    @DeleteMapping("/delete/{empId}")
    public String deletePayroll(@PathVariable String empId) {
        payrollService.deletePayroll(empId);
        return "Payroll entry deleted successfully!";
    }
}
