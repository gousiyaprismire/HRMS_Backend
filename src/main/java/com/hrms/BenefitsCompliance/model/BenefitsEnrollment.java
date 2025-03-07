package com.hrms.BenefitsCompliance.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "benefits_enrollment")
public class BenefitsEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId; // Reference to the employee enrolling in benefits

    private String healthInsurancePlan;
    private String retirementPlan;
    private String dentalInsurance;
    private String visionInsurance;
    private LocalDate enrollmentDate;

    private String status; // e.g., "Pending", "Approved", "Rejected"
}
