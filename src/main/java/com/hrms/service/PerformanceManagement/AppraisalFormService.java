package com.hrms.service.PerformanceManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hrms.model.PerformanceManagement.AppraisalForm;

@Service
public interface AppraisalFormService {

	AppraisalForm createAppraisalForm(AppraisalForm appraisalForm);
	Optional<AppraisalForm> getAppraisalFormById(Long id);
	List<AppraisalForm> getAllAppraisalForms();
	AppraisalForm updateAppraisalForm(Long id, AppraisalForm updatedForm);
	void deleteAppraisalForm(Long id);
	
}
