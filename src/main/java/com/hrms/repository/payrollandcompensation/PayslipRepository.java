package com.hrms.repository.payrollandcompensation;

import com.hrms.model.payrollandcompensation.PayslipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayslipRepository extends JpaRepository<PayslipEntity, Long> {
}
