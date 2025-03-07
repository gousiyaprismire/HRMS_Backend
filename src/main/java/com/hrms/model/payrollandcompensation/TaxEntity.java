package com.hrms.model.payrollandcompensation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tax_reports")
public class TaxEntity {

    @Id
    private String empId;
    private String name;
    private double providentFund;
    private double insurance;
    private double deductions;
    private String month;
    private String year;

    public TaxEntity() {}

    public TaxEntity(String empId, String name, double providentFund, double insurance, double deductions, String month, String year) {
        this.empId = empId;
        this.name = name;
        this.providentFund = providentFund;
        this.insurance = insurance;
        this.deductions = deductions;
        this.month = month;
        this.year = year;
    }

    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getProvidentFund() { return providentFund; }
    public void setProvidentFund(double providentFund) { this.providentFund = providentFund; }

    public double getInsurance() { return insurance; }
    public void setInsurance(double insurance) { this.insurance = insurance; }

    public double getDeductions() { return deductions; }
    public void setDeductions(double deductions) { this.deductions = deductions; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }
}
