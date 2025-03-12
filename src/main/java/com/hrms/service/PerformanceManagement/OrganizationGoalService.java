package com.hrms.service.PerformanceManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hrms.model.PerformanceManagement.OrganizationGoal;

@Service
public interface OrganizationGoalService {

	List<OrganizationGoal> getAllGoals();
	Optional<OrganizationGoal> getOrganizationGoalById(Long id);
	OrganizationGoal createOrganizationGoal(OrganizationGoal goal);
	OrganizationGoal updateOrganizationGoal(Long id, OrganizationGoal goal);
	void deleteOrganizationGoal(Long id);
	
}
