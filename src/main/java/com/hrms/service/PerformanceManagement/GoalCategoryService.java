package com.hrms.service.PerformanceManagement;

import java.util.List;
import java.util.Optional;

import com.hrms.model.PerformanceManagement.GoalCategory;

public interface GoalCategoryService {

	List<GoalCategory> getAllCategories();
	Optional<GoalCategory> getCategoryById(Long id);
	GoalCategory createCategory(GoalCategory category);
	GoalCategory updateCategory(Long id, GoalCategory category);
	void deleteCategory(Long id);
	
}
