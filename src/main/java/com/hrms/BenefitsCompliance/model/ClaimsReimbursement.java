package com.hrms.BenefitsCompliance.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClaimsReimbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Long employeeId;
    private String claimType;
    private BigDecimal claimAmount;
    private LocalDate claimDate;
    private String status;
    private String remarks;
}
