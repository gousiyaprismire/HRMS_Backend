package com.hrms.BenefitsCompliance.service;

import com.hrms.BenefitsCompliance.dto.BenefitsComplianceDTO;

import java.util.List;

public interface BenefitsComplianceService {
    List<BenefitsComplianceDTO> getAllComplianceRecords();
    BenefitsComplianceDTO getComplianceById(Long id);
    BenefitsComplianceDTO createComplianceRecord(BenefitsComplianceDTO dto);
    BenefitsComplianceDTO updateComplianceRecord(Long id, BenefitsComplianceDTO dto);
    void deleteComplianceRecord(Long id);
}
