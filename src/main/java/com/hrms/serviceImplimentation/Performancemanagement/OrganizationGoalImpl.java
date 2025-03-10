package com.hrms.serviceImplimentation.Performancemanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.model.PerformanceManagement.OrganizationGoal;
import com.hrms.repository.PerformanceManagement.OrganizationGoalRepository;
import com.hrms.service.PerformanceManagement.OrganizationGoalService;

@Service
public class OrganizationGoalImpl implements OrganizationGoalService{

	@Autowired
	private OrganizationGoalRepository organizationGoalRepository;
	
	@Override
	public List<OrganizationGoal> getAllGoals() {
		return organizationGoalRepository.findAll();
	}

	@Override
	public Optional<OrganizationGoal> getOrganizationGoalById(Long id) {
		return organizationGoalRepository.findById(id);
	}

	@Override
	public OrganizationGoal createOrganizationGoal(OrganizationGoal goal) {
		return organizationGoalRepository.save(goal);
	}

	@Override
	public OrganizationGoal updateOrganizationGoal(Long id, OrganizationGoal goal) {
		return null;
	}

	@Override
	public void deleteOrganizationGoal(Long id) {
		organizationGoalRepository.deleteById(id);
		
	}

}
