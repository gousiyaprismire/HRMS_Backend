package com.hrms.model.payrollandcompensation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payroll_processing")
public class PayrollEntity {

    @Id
    private String empId;
    private String name;
    private double grossPay;
    private double netPay;
    private double deductions;
    private String month;
    private String year;

    public PayrollEntity() {}

    public PayrollEntity(String empId, String name, double grossPay, double netPay, double deductions, String month, String year) {
        this.empId = empId;
        this.name = name;
        this.grossPay = grossPay;
        this.netPay = netPay;
        this.deductions = deductions;
        this.month = month;
        this.year = year;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
