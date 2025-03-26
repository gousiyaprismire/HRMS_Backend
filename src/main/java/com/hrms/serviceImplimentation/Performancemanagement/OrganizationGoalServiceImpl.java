package com.hrms.serviceImplimentation.Performancemanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.model.PerformanceManagement.OrganizationGoal;
import com.hrms.repository.PerformanceManagement.OrganizationGoalRepository;
import com.hrms.service.PerformanceManagement.OrganizationGoalService;

import jakarta.transaction.Transactional;

@Service
public class OrganizationGoalServiceImpl implements OrganizationGoalService{

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
	    if (goal.getGoalDescription() == null || goal.getGoalDescription().trim().isEmpty()) {
	        throw new IllegalArgumentException("Goal description cannot be null or empty.");
	    }
	    return organizationGoalRepository.save(goal);
	}

	@Override
	@Transactional
	public OrganizationGoal updateOrganizationGoal(Long id, OrganizationGoal goalDetails) {
	    return organizationGoalRepository.findById(id).map(existingGoal -> {
	        existingGoal.setGoalDescription(goalDetails.getGoalDescription());
	        existingGoal.setTarget(goalDetails.getTarget());
	        existingGoal.setRollupMethod(goalDetails.getRollupMethod());
	        existingGoal.setPeriod(goalDetails.getPeriod()); 
	        return organizationGoalRepository.save(existingGoal);
	    }).orElseThrow(() -> new RuntimeException("Goal with ID " + id + " not found."));
	}
	@Override
	public void deleteOrganizationGoal(Long id) {
		organizationGoalRepository.deleteById(id);
		
	}
}
