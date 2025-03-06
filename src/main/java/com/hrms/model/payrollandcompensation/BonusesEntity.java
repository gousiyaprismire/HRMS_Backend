package com.hrms.model.payrollandcompensation;

import jakarta.persistence.*;

@Entity
@Table(name = "bonuses")
public class BonusesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String empId;
    private String name;
    private double bonusAmount;
    private String bonusType;
    private String month;
    private String year;

    public BonusesEntity() {}

    public BonusesEntity(Long id, String empId, String name, double bonusAmount, String bonusType, String month, String year) {
        this.id = id;
        this.empId = empId;
        this.name = name;
        this.bonusAmount = bonusAmount;
        this.bonusType = bonusType;
        this.month = month;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public String getBonusType() {
        return bonusType;
    }

    public void setBonusType(String bonusType) {
        this.bonusType = bonusType;
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
