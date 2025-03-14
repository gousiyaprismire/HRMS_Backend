package com.hrms.serviceImplimentation.Performancemanagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.model.PerformanceManagement.AppraisalForm;
import com.hrms.repository.PerformanceManagement.AppraisalFormRepository;
import com.hrms.service.PerformanceManagement.AppraisalFormService;

@Service
public class AppraisalFormServiceImpl implements AppraisalFormService {

	@Autowired
    private AppraisalFormRepository appraisalFormRepository;

    @Override
    public List<AppraisalForm> getAllAppraisalForms() {
        return appraisalFormRepository.findAll();
    }

    @Override
    public AppraisalForm getAppraisalFormById(Long id) {
        Optional<AppraisalForm> optional = appraisalFormRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public AppraisalForm createAppraisalForm(AppraisalForm appraisalForm) {
        return appraisalFormRepository.save(appraisalForm);
    }

    @Override
    public AppraisalForm updateAppraisalForm(Long id, AppraisalForm appraisalForm) {
        if (appraisalFormRepository.existsById(id)) {
            appraisalForm.setId(id);
            return appraisalFormRepository.save(appraisalForm);
        }
        return null;
    }

    @Override
    public void deleteAppraisalForm(Long id) {
        appraisalFormRepository.deleteById(id);
    }
}
