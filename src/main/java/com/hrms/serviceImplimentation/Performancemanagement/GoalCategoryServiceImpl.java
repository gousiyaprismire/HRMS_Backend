package com.hrms.serviceImplimentation.Performancemanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.model.PerformanceManagement.GoalCategory;
import com.hrms.repository.PerformanceManagement.GoalCategoryRepository;
import com.hrms.service.PerformanceManagement.GoalCategoryService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GoalCategoryServiceImpl implements GoalCategoryService {

	@Autowired
	private GoalCategoryRepository goalCategoryRepository;
	
	@Override
	public List<GoalCategory> getAllCategories() {
		return goalCategoryRepository.findAll();
	}

	@Override
    public Optional<GoalCategory> getCategoryById(Long id) {
        return goalCategoryRepository.findById(id);
    }

	@Override
	public GoalCategory createCategory(GoalCategory category) {
		return goalCategoryRepository.save(category);
	}

	 @Override
	    public GoalCategory updateCategory(Long id, GoalCategory categoryDetails) {
	        return goalCategoryRepository.findById(id).map(existingCategory -> {
	            existingCategory.setName(categoryDetails.getName());
	            existingCategory.setDescription(categoryDetails.getDescription());
	            return goalCategoryRepository.save(existingCategory);
	        }).orElse(null);
	    }

	@Override
	public void deleteCategory(Long id) {
		goalCategoryRepository.deleteById(id);
		
	}
}
