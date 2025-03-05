package com.hrms.service.Recruitment;

import com.hrms.model.Recruitment.Applicant;
import com.hrms.repository.Recruitment.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    public Optional<Applicant> getApplicantById(Long id) {
        return applicantRepository.findById(id);
    }

    public Applicant submitApplication(Applicant applicant) {
        applicant.setStatus("Pending");
        return applicantRepository.save(applicant);
    }

    public Applicant updateApplicantStatus(Long id, String status) {
        Optional<Applicant> applicantOptional = applicantRepository.findById(id);
        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();
            applicant.setStatus(status);
            return applicantRepository.save(applicant);
        } else {
            throw new RuntimeException("Applicant not found");
        }
    }
}
