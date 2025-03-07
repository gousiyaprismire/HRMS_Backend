package com.hrms.BenefitsCompliance.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BenefitsComplianceDTO {
    private Long id;
    private String complianceType;
    private String description;
    private LocalDate createdDate;
    private String status;
}
