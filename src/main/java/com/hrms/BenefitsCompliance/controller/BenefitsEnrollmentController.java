package com.hrms.BenefitsCompliance.controller;

import com.hrms.BenefitsCompliance.dto.BenefitsEnrollmentDTO;
import com.hrms.BenefitsCompliance.service.BenefitsEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/benefits-enrollment")
public class BenefitsEnrollmentController {

    @Autowired
    private BenefitsEnrollmentService service;

    @PostMapping
    public ResponseEntity<BenefitsEnrollmentDTO> enrollBenefits(@RequestBody BenefitsEnrollmentDTO dto) {
        return ResponseEntity.ok(service.enrollBenefits(dto));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<BenefitsEnrollmentDTO>> getEnrollmentsByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getEnrollmentsByEmployeeId(employeeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BenefitsEnrollmentDTO> getEnrollmentById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEnrollmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BenefitsEnrollmentDTO> updateEnrollment(@PathVariable Long id, @RequestBody BenefitsEnrollmentDTO dto) {
        return ResponseEntity.ok(service.updateEnrollment(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Long id) {
        service.deleteEnrollment(id);
        return ResponseEntity.ok("Enrollment deleted successfully.");
    }
}
