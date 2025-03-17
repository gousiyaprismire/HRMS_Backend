package com.hrms.controller.Recruitment;


import com.hrms.model.Recruitment.Applicant;
import com.hrms.repository.Recruitment.ApplicantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/applicants")
@CrossOrigin(origins = "http://localhost:3000")
public class ApplicantController {

    private final ApplicantRepository applicantRepository;

    public ApplicantController(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }


    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable Long id) {
        Optional<Applicant> applicant = applicantRepository.findById(id);
        return applicant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public Applicant createApplicant(@RequestBody Applicant applicant) {
        return applicantRepository.save(applicant);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Applicant> updateApplicant(@PathVariable Long id, @RequestBody Applicant updatedApplicant) {
        return applicantRepository.findById(id)
                .map(applicant -> {
                    applicant.setName(updatedApplicant.getName());
                    applicant.setEmail(updatedApplicant.getEmail());
                    applicant.setMobile(updatedApplicant.getMobile());
                    applicant.setDegree(updatedApplicant.getDegree());
                    applicant.setDepartment(updatedApplicant.getDepartment());
                    applicant.setAppliedJob(updatedApplicant.getAppliedJob());
                    applicant.setExpectedSalary(updatedApplicant.getExpectedSalary());
                    applicant.setResumeUrl(updatedApplicant.getResumeUrl());
                    applicant.setStatus(updatedApplicant.getStatus());
                    applicant.setAppreciation(updatedApplicant.getAppreciation());
                    return ResponseEntity.ok(applicantRepository.save(applicant));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteApplicant(@PathVariable Long id) {
        return applicantRepository.findById(id)
                .map(applicant -> {
                    applicantRepository.delete(applicant);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}



