package com.hrms.BenefitsCompliance.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClaimsReimbursementDTO {
    private Long id;
    private Long employeeId;
    private String claimType;
    private BigDecimal claimAmount;
    private LocalDate claimDate;
    private String status;
    private String remarks;
}
