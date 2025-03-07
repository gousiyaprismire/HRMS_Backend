package com.hrms.BenefitsCompliance.service;

import com.hrms.BenefitsCompliance.dto.ClaimsReimbursementDTO;

import java.util.List;

public interface ClaimsReimbursementService {
    ClaimsReimbursementDTO submitClaim(ClaimsReimbursementDTO dto);
    List<ClaimsReimbursementDTO> getClaimsByEmployeeId(Long employeeId);
    ClaimsReimbursementDTO getClaimById(Long id);
    ClaimsReimbursementDTO updateClaim(Long id, ClaimsReimbursementDTO dto);
    void deleteClaim(Long id);
}
