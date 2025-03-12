package com.hrms.repository.PerformanceManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.model.PerformanceManagement.PerformancePeriod;

@Repository
public interface PerformancePeriodRepository extends JpaRepository<PerformancePeriod, Long>{

}
