package com.hrms.model.Recruitment;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name= "Employee")
public class Joblisting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String department;
    private String location;
    private String jobType;
    private String description;
    private LocalDate postedDate;
    private LocalDate applicationDeadline;


    public Joblisting() {
    }


    public Joblisting(Long id, String title, String department, String location, String jobType, String description, LocalDate postedDate, LocalDate applicationDeadline) {
        this.id = id;
        this.title = title;
        this.department = department;
        this.location = location;
        this.jobType = jobType;
        this.description = description;
        this.postedDate = postedDate;
        this.applicationDeadline = applicationDeadline;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }

    public String getLocation() {
        return location;
    }

    public String getJobType() {
        return jobType;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public LocalDate getApplicationDeadline() {
        return applicationDeadline;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public void setApplicationDeadline(LocalDate applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }
}
