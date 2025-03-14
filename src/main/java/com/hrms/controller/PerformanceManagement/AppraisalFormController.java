package com.hrms.controller.PerformanceManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.model.PerformanceManagement.AppraisalForm;
import com.hrms.service.PerformanceManagement.AppraisalFormService;

@RestController
@RequestMapping("/api/appraisal_forms")
public class AppraisalFormController {

	 @Autowired
	    private AppraisalFormService appraisalFormService;

	    @GetMapping
	    public List<AppraisalForm> getAllAppraisalForms() {
	        return appraisalFormService.getAllAppraisalForms();
	    }

	    @GetMapping("/{id}")
	    public AppraisalForm getAppraisalFormById(@PathVariable Long id) {
	        return appraisalFormService.getAppraisalFormById(id);
	    }

	    @PostMapping
	    public AppraisalForm createAppraisalForm(@RequestBody AppraisalForm appraisalForm) {
	        return appraisalFormService.createAppraisalForm(appraisalForm);
	    }

	    @PutMapping("/{id}")
	    public AppraisalForm updateAppraisalForm(@PathVariable Long id, @RequestBody AppraisalForm appraisalForm) {
	        return appraisalFormService.updateAppraisalForm(id, appraisalForm);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteAppraisalForm(@PathVariable Long id) {
	        appraisalFormService.deleteAppraisalForm(id);
	    }
	}
