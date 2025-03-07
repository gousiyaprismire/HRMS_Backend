package com.hrms.BenefitsCompliance.controller;

import com.hrms.BenefitsCompliance.dto.ClaimsReimbursementDTO;
import com.hrms.BenefitsCompliance.service.ClaimsReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims-reimbursement")
public class ClaimsReimbursementController {

    @Autowired
    private ClaimsReimbursementService service;

    @PostMapping
    public ResponseEntity<ClaimsReimbursementDTO> submitClaim(@RequestBody ClaimsReimbursementDTO dto) {
        return ResponseEntity.ok(service.submitClaim(dto));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<ClaimsReimbursementDTO>> getClaimsByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getClaimsByEmployeeId(employeeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaimsReimbursementDTO> getClaimById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getClaimById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaimsReimbursementDTO> updateClaim(@PathVariable Long id, @RequestBody ClaimsReimbursementDTO dto) {
        return ResponseEntity.ok(service.updateClaim(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClaim(@PathVariable Long id) {
        service.deleteClaim(id);
        return ResponseEntity.ok("Claim deleted successfully.");
    }
}
