package com.hrms.controller.PerformanceManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.model.PerformanceManagement.PerformancePeriod;
import com.hrms.service.PerformanceManagement.PerformancePeriodService;

@RestController
@RequestMapping("/api/performance_periods")
public class PerformancePeriodController {
	
	@Autowired
	private PerformancePeriodService performancePeriodService;
	
	@GetMapping
	public List<PerformancePeriod> getAllPerformancePeriod(){
		return performancePeriodService.getAllPerformancePeriods();
	}
	
	@GetMapping("{id}")
	public Optional<PerformancePeriod> getPerformancePeriodById(@PathVariable Long id){
		return performancePeriodService.getPerformancePeriodById(id);
	}
	
	@PostMapping
	public PerformancePeriod createPerformancePeriod(@RequestBody PerformancePeriod performnacePeriod) {
		return performancePeriodService.createPerformancePeriod(performnacePeriod);
	}
	
	@PutMapping("{id}")
	public PerformancePeriod updatePerformancePeriod(@PathVariable Long id, @RequestBody PerformancePeriod performancePeriod) {
		return performancePeriodService.updatePerformanceperiod(id, performancePeriod);
	}
	
	@DeleteMapping("/{id}")
	public void deletePerformancePeriod(@PathVariable  Long id) {
		performancePeriodService.deletePerformancePeriod(id);
	}

}
