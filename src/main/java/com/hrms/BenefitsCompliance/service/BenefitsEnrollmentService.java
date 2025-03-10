package com.hrms.BenefitsCompliance.service;

import com.hrms.BenefitsCompliance.dto.BenefitsEnrollmentDTO;

import java.util.List;

public interface BenefitsEnrollmentService {
    BenefitsEnrollmentDTO enrollBenefits(BenefitsEnrollmentDTO dto);
    List<BenefitsEnrollmentDTO> getEnrollmentsByEmployeeId(Long employeeId);
    BenefitsEnrollmentDTO getEnrollmentById(Long id);
    BenefitsEnrollmentDTO updateEnrollment(Long id, BenefitsEnrollmentDTO dto);
    void deleteEnrollment(Long id);
}
