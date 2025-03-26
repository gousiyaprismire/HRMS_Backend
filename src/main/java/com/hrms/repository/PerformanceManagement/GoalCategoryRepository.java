package com.hrms.repository.PerformanceManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.model.PerformanceManagement.GoalCategory;

@Repository
public interface GoalCategoryRepository extends JpaRepository<GoalCategory, Long>{

}



