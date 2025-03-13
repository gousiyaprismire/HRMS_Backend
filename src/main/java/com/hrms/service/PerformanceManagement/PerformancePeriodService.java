package com.hrms.service.PerformanceManagement;

import java.util.List;
import java.util.Optional;

import com.hrms.model.PerformanceManagement.PerformancePeriod;

public interface PerformancePeriodService {

	List<PerformancePeriod> getAllPerformancePeriods();
	PerformancePeriod createPerformancePeriod(PerformancePeriod performancePeriod);
	Optional<PerformancePeriod> getPerformancePeriodById(Long id);
	PerformancePeriod updatePerformanceperiod(Long id, PerformancePeriod performancePeriod);
	void deletePerformancePeriod(Long id);
	
}

