package com.hrms.BenefitsCompliance.repository;

import com.hrms.BenefitsCompliance.model.BenefitsEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenefitsEnrollmentRepository extends JpaRepository<BenefitsEnrollment, Long> {
    List<BenefitsEnrollment> findByEmployeeId(Long employeeId);
}
