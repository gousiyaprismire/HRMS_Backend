package com.hrms.BenefitsCompliance.repository;

import com.hrms.BenefitsCompliance.model.BenefitsCompliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitsComplianceRepository extends JpaRepository<BenefitsCompliance, Long> {
}
