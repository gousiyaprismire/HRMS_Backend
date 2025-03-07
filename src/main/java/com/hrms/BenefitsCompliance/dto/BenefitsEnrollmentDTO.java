package com.hrms.BenefitsCompliance.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BenefitsEnrollmentDTO {
    private Long id;
    private Long employeeId;
    private String healthInsurancePlan;
    private String retirementPlan;
    private String dentalInsurance;
    private String visionInsurance;
    private LocalDate enrollmentDate;
    private String status;
}
