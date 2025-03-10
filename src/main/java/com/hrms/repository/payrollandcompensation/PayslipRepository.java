package com.hrms.repository.payrollandcompensation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.model.payrollandcompensation.PayslipEntity;

@Repository
public interface PayslipRepository extends JpaRepository<PayslipEntity, Long> {
}
