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

import com.hrms.model.PerformanceManagement.OrganizationGoal;
import com.hrms.service.PerformanceManagement.OrganizationGoalService;


@RestController
@RequestMapping("/api/organization_goals")
public class OrganizationGoalController {

	@Autowired
	private OrganizationGoalService organizationGoalService;
	
	
	@GetMapping
	public List<OrganizationGoal> getAllOrganizationGoals() {
		return organizationGoalService.getAllGoals();
	}
	
	@GetMapping("/{id}")
	public Optional<OrganizationGoal> getOrganizationGoalById(@PathVariable Long id) {
		return organizationGoalService.getOrganizationGoalById(id);
	}
	
	@PostMapping
	public OrganizationGoal createOrganizationGoal(@RequestBody OrganizationGoal goal) {
		return organizationGoalService.createOrganizationGoal(goal);
	}
	
	@PutMapping("/{id}")
	public OrganizationGoal updateOrganizationGoal(@PathVariable Long id, @RequestBody OrganizationGoal goal) {
		return organizationGoalService.updateOrganizationGoal(id, goal);
	}
	
	@DeleteMapping("/{id}")
	void deleteOrganizationGoal(@PathVariable Long id) {
		organizationGoalService.deleteOrganizationGoal(id);
	}
}
