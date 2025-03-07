package com.hrms.BenefitsCompliance.repository;

import com.hrms.BenefitsCompliance.model.ClaimsReimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimsReimbursementRepository extends JpaRepository<ClaimsReimbursement, Long> {
    List<ClaimsReimbursement> findByEmployeeId(Long employeeId);
}
