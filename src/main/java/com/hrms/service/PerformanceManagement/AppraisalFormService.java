package com.hrms.service.PerformanceManagement;

import java.util.List;
import java.util.Optional;

import com.hrms.model.PerformanceManagement.AppraisalForm;

public interface AppraisalFormService {
    List<AppraisalForm> getAllAppraisalForms();
    AppraisalForm getAppraisalFormById(Long id);
    AppraisalForm createAppraisalForm(AppraisalForm appraisalForm);
    AppraisalForm updateAppraisalForm(Long id, AppraisalForm appraisalForm);
    void deleteAppraisalForm(Long id);
}
