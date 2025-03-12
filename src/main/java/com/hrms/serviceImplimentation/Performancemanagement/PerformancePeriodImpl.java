package com.hrms.serviceImplimentation.Performancemanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;

import com.hrms.model.PerformanceManagement.PerformancePeriod;
import com.hrms.repository.PerformanceManagement.PerformancePeriodRepository;
import com.hrms.service.PerformanceManagement.PerformancePeriodService;

public class PerformancePeriodImpl implements PerformancePeriodService{

	@Autowired
	private PerformancePeriodRepository performancePeriodRepository;
	
	@Override
	public List<PerformancePeriod> getAllPerformancePeriods() {
		return performancePeriodRepository.findAll();
	}

	@Override
	public PerformancePeriod createPerformancePeriod(PerformancePeriod performancePeriod) {
		return performancePeriodRepository.save(performancePeriod);
	}

	@Override
	public Optional<PerformancePeriod> getPerformancePeriodById(Long id) {
		return performancePeriodRepository.findById(id);
	}

	@Override
	public PerformancePeriod updatePerformanceperiod(Long id, PerformancePeriod performancePeriod) {
		return performancePeriodRepository.findById(id).map(existingPeriod -> {
            existingPeriod.setPeriodName(performancePeriod.getPeriodName());
            existingPeriod.setStartDate(performancePeriod.getStartDate());
            existingPeriod.setEndDate(performancePeriod.getEndDate());
            return performancePeriodRepository.save(existingPeriod);
        }).orElseThrow(() -> new RuntimeException("Performance Period not found"));
	}

	@Override
	public void deletePerformancePeriod(Long id) {
		performancePeriodRepository.deleteById(id);
		
	}
}
