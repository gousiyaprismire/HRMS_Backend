package com.hrms.controller.Recruitment;

import com.hrms.model.Recruitment.Applicant;
import com.hrms.service.Recruitment.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applicants")

@CrossOrigin(origins = "http://localhost:3000")

public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping
    public ResponseEntity<List<Applicant>> getAllApplicants() {
        List<Applicant> applicants = applicantService.getAllApplicants();
        return ResponseEntity.ok(applicants);
    }

    @PostMapping
    public ResponseEntity<Applicant> submitApplication(@RequestBody Applicant applicant) {
        Applicant savedApplicant = applicantService.submitApplication(applicant);
        return ResponseEntity.ok(savedApplicant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable Long id) {
        Optional<Applicant> applicant = applicantService.getApplicantById(id);
        return applicant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Applicant> updateApplicantStatus(@PathVariable Long id, @RequestParam String status) {
        try {
            Applicant updatedApplicant = applicantService.updateApplicantStatus(id, status);
            return ResponseEntity.ok(updatedApplicant);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
