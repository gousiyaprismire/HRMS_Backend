package com.hrms.model.Recruitment;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "offer_letters")
public class OfferLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "candidate_email", nullable = false)
    private String candidateEmail;

    @Column(name = "candidate_name", nullable = false)
    private String candidateName;

    @Column(name = "employment_type")
    private String employmentType;

    @Column(name = "hr_contact_person")
    private String hrContactPerson;

    @Column(name = "job_position", nullable = false)
    private String jobPosition;

    @Column(name = "offer_date")
    private LocalDate offerDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "salary_package")
    private Double salaryPackage;

    @Column(name = "status")
    private String status;

    @Column(name = "work_location")
    private String workLocation;


    public OfferLetter() {}

    public OfferLetter(String candidateEmail, String candidateName, String employmentType, String hrContactPerson,
                       String jobPosition, LocalDate offerDate, String phoneNumber, Double salaryPackage,
                       String status, String workLocation) {
        this.candidateEmail = candidateEmail;
        this.candidateName = candidateName;
        this.employmentType = employmentType;
        this.hrContactPerson = hrContactPerson;
        this.jobPosition = jobPosition;
        this.offerDate = offerDate;
        this.phoneNumber = phoneNumber;
        this.salaryPackage = salaryPackage;
        this.status = status;
        this.workLocation = workLocation;
    }


    public Long getId() {
        return id;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getHrContactPerson() {
        return hrContactPerson;
    }

    public void setHrContactPerson(String hrContactPerson) {
        this.hrContactPerson = hrContactPerson;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public LocalDate getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(LocalDate offerDate) {
        this.offerDate = offerDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getSalaryPackage() {
        return salaryPackage;
    }

    public void setSalaryPackage(Double salaryPackage) {
        this.salaryPackage = salaryPackage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
}

