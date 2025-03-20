package com.hrms.model.Recruitment;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "offer_letters") // Matches the database table
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "candidate_name", nullable = false)
    private String candidateName;

    @Column(name = "candidate_email", nullable = false, unique = true)
    private String candidateEmail;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "job_position", nullable = false)
    private String jobPosition;

    @Column(name = "salary_package", nullable = false, precision = 10, scale = 2)
    private BigDecimal salaryPackage;

    @Enumerated(EnumType.STRING)
    @Column(name = "employment_type", nullable = false)
    private EmploymentType employmentType;

    @Column(name = "work_location", nullable = false)
    private String workLocation;

    @Column(name = "offer_date", nullable = false)
    private LocalDate offerDate;

    @Column(name = "hr_contact_person", nullable = false)
    private String hrContactPerson;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status = Status.PENDING;

    public Offer() {}

    public Offer(String candidateName, String candidateEmail, String phoneNumber, String jobPosition,
                 BigDecimal salaryPackage, EmploymentType employmentType, String workLocation,
                 LocalDate offerDate, String hrContactPerson, Status status) {
        this.candidateName = candidateName;
        this.candidateEmail = candidateEmail;
        this.phoneNumber = phoneNumber;
        this.jobPosition = jobPosition;
        this.salaryPackage = salaryPackage;
        this.employmentType = employmentType;
        this.workLocation = workLocation;
        this.offerDate = offerDate;
        this.hrContactPerson = hrContactPerson;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public BigDecimal getSalaryPackage() {
        return salaryPackage;
    }

    public void setSalaryPackage(BigDecimal salaryPackage) {
        this.salaryPackage = salaryPackage;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public LocalDate getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(LocalDate offerDate) {
        this.offerDate = offerDate;
    }

    public String getHrContactPerson() {
        return hrContactPerson;
    }

    public void setHrContactPerson(String hrContactPerson) {
        this.hrContactPerson = hrContactPerson;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum EmploymentType {
        FULL_TIME, PART_TIME, CONTRACT
    }

    public enum Status {
        PENDING, ACCEPTED, REJECTED
    }
}
