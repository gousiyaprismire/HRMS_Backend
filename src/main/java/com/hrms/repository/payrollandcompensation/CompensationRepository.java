package com.hrms.repository.payrollandcompensation;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.model.payrollandcompensation.Compensation;

public interface CompensationRepository extends JpaRepository<Compensation, Long> {
}
