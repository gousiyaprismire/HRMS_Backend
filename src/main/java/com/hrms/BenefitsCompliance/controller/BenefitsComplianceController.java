package com.hrms.BenefitsCompliance.controller;

import com.hrms.BenefitsCompliance.dto.BenefitsComplianceDTO;
import com.hrms.BenefitsCompliance.service.BenefitsComplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/benefits-compliance")
public class BenefitsComplianceController {

    @Autowired
    private BenefitsComplianceService service;

    @GetMapping
    public List<BenefitsComplianceDTO> getAllComplianceRecords() {
        return service.getAllComplianceRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BenefitsComplianceDTO> getComplianceById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getComplianceById(id));
    }

    @PostMapping
    public ResponseEntity<BenefitsComplianceDTO> createComplianceRecord(@RequestBody BenefitsComplianceDTO dto) {
        return ResponseEntity.ok(service.createComplianceRecord(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BenefitsComplianceDTO> updateComplianceRecord(@PathVariable Long id, @RequestBody BenefitsComplianceDTO dto) {
        return ResponseEntity.ok(service.updateComplianceRecord(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplianceRecord(@PathVariable Long id) {
        service.deleteComplianceRecord(id);
        return ResponseEntity.noContent().build();
    }
}
