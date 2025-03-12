package com.hrms.serviceImplimentation.Performancemanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hrms.model.PerformanceManagement.AppraisalForm;
import com.hrms.repository.PerformanceManagement.AppraisalFormRepository;
import com.hrms.service.PerformanceManagement.AppraisalFormService;

public class AppraisalFormServiceImpl implements AppraisalFormService {

	@Autowired
	private AppraisalFormRepository appraisalFormRepository;
	
	@Override
	public AppraisalForm createAppraisalForm(AppraisalForm appraisalForm) {
		return appraisalFormRepository.save(appraisalForm);
	}

	@Override
	public Optional<AppraisalForm> getAppraisalFormById(Long id) {
		return appraisalFormRepository.findById(id);
	}

	@Override
	public List<AppraisalForm> getAllAppraisalForms() {
		return appraisalFormRepository.findAll();
	}

	@Override
	public AppraisalForm updateAppraisalForm(Long id, AppraisalForm updatedForm) {
		return appraisalFormRepository.findById(id).map(existingForm -> {
            existingForm.setEmployeeName(updatedForm.getEmployeeName());
            existingForm.setManagerName(updatedForm.getManagerName());
            existingForm.setStatus(updatedForm.getStatus());
            existingForm.setLastAction(updatedForm.getLastAction());
            return appraisalFormRepository.save(existingForm);
        }).orElseThrow(() -> new RuntimeException("AppraisalForm not found with ID: " + id));
	}

	@Override
	public void deleteAppraisalForm(Long id) {
		appraisalFormRepository.deleteById(id);
		
	}
}
