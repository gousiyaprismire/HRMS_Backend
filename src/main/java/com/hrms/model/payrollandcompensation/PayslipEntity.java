package com.hrms.model.payrollandcompensation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payslips")
public class PayslipEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String empId;
    private String name;
    private String pan;
    private String uan;
    private int bankDays;
    private int lopDays;
    private String doj;
    private String gender;
    private double totalEarnings;
    

    public PayslipEntity() {}

    public PayslipEntity(String empId, String name, String pan, String uan, int bankDays, int lopDays, String doj, String gender, double totalEarnings) {
        this.empId = empId;
        this.name = name;
        this.pan = pan;
        this.uan = uan;
        this.bankDays = bankDays;
        this.lopDays = lopDays;
        this.doj = doj;
        this.gender = gender;
        this.totalEarnings = totalEarnings;
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

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getUan() {
        return uan;
    }

    public void setUan(String uan) {
        this.uan = uan;
    }

    public int getBankDays() {
        return bankDays;
    }

    public void setBankDays(int bankDays) {
        this.bankDays = bankDays;
    }

    public int getLopDays() {
        return lopDays;
    }

    public void setLopDays(int lopDays) {
        this.lopDays = lopDays;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {  
        this.id = id;
    }
}
