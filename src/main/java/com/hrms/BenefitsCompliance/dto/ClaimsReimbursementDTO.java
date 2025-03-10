package com.hrms.BenefitsCompliance.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
