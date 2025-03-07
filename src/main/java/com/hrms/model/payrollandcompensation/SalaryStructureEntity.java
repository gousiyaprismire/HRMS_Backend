package com.hrms.model.payrollandcompensation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "salary_structures")
public class SalaryStructureEntity {

    @Id
    private String empId;
    private String name;
    private double basicPay;
    private double hra;
    private double pf;
    private double deductions;
    private double travelAllowance;
    private double foodAllowance;
    private double pfEmployee;
    private String month;
    private String year;

  
    public SalaryStructureEntity() {}

    public SalaryStructureEntity(String empId, String name, double basicPay, double hra, double pf, double deductions, 
                                 double travelAllowance, double foodAllowance, double pfEmployee, String month, String year) {
        this.empId = empId;
        this.name = name;
        this.basicPay = basicPay;
        this.hra = hra;
        this.pf = pf;
        this.deductions = deductions;
        this.travelAllowance = travelAllowance;
        this.foodAllowance = foodAllowance;
        this.pfEmployee = pfEmployee;
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

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getPf() {
        return pf;
    }

    public void setPf(double pf) {
        this.pf = pf;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getTravelAllowance() {
        return travelAllowance;
    }

    public void setTravelAllowance(double travelAllowance) {
        this.travelAllowance = travelAllowance;
    }

    public double getFoodAllowance() {
        return foodAllowance;
    }

    public void setFoodAllowance(double foodAllowance) {
        this.foodAllowance = foodAllowance;
    }

    public double getPfEmployee() {
        return pfEmployee;
    }

    public void setPfEmployee(double pfEmployee) {
        this.pfEmployee = pfEmployee;
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
