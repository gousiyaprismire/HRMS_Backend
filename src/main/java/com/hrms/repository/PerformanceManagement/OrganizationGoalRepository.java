package com.hrms.repository.PerformanceManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.model.PerformanceManagement.OrganizationGoal;

@Repository
public interface OrganizationGoalRepository extends JpaRepository<OrganizationGoal, Long>{
	
}
