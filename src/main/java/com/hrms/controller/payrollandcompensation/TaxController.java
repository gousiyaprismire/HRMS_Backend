package com.hrms.controller.payrollandcompensation;

import com.hrms.model.payrollandcompensation.TaxEntity;
import com.hrms.service.payrollandcompensation.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tax-reports")
@CrossOrigin(origins = "*")
public class TaxController {

    @Autowired
    private TaxService taxService;

    @GetMapping("/all")
    public List<TaxEntity> getAllTaxReports() {
        return taxService.getAllTaxReports();
    }

    @GetMapping("/{empId}")
    public ResponseEntity<TaxEntity> getTaxReportById(@PathVariable String empId) {
        TaxEntity taxReport = taxService.getTaxReportById(empId);
        return taxReport != null ? ResponseEntity.ok(taxReport) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TaxEntity> createTaxReport(@RequestBody TaxEntity taxReport) {
        TaxEntity savedReport = taxService.saveTaxReport(taxReport);
        return ResponseEntity.ok(savedReport);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<TaxEntity> updateTaxReport(@PathVariable String empId, @RequestBody TaxEntity taxReport) {
        TaxEntity updatedReport = taxService.updateTaxReport(empId, taxReport);
        return updatedReport != null ? ResponseEntity.ok(updatedReport) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<Void> deleteTaxReport(@PathVariable String empId) {
        taxService.deleteTaxReport(empId);
        return ResponseEntity.noContent().build();
    }
}
