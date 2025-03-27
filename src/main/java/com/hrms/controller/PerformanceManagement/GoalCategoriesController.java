package com.hrms.controller.PerformanceManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.model.PerformanceManagement.GoalCategory;
import com.hrms.service.PerformanceManagement.GoalCategoryService;

@RestController
@RequestMapping("/api/goal_categories")
@CrossOrigin(origins = "http://localhost:3000")
public class GoalCategoriesController {
	
	@Autowired
	private GoalCategoryService goalCategoryService;

	@GetMapping
	public List<GoalCategory> getAllCategories() {
		return goalCategoryService.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public Optional<GoalCategory> getCategoryById(@PathVariable Long id) {
		return goalCategoryService.getCategoryById(id);
	}
	
	@PostMapping
	public GoalCategory createCategory(@RequestBody GoalCategory category) {
		return goalCategoryService.createCategory(category);
	}
	
	@PutMapping("/{id}")
	public GoalCategory updateCategory(@PathVariable Long id, @RequestBody GoalCategory categoryDetails) {
		return goalCategoryService.updateCategory(id, categoryDetails);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteGoalCategory(@PathVariable Long id) {
		goalCategoryService.deleteCategory(id);
	}
}

