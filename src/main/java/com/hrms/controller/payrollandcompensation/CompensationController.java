package com.hrms.controller.payrollandcompensation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hrms.model.payrollandcompensation.Compensation;
import com.hrms.service.payrollandcompensation.CompensationService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/compensations")
public class CompensationController {

    private final CompensationService service;

    public CompensationController(CompensationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createCompensation(@RequestBody Compensation compensation) {
        try {
            Compensation saved = service.saveCompensation(compensation);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Failed to add compensation. Reason: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompensation(@PathVariable Long id, @RequestBody Compensation compensation) {
        try {
            Compensation updated = service.updateCompensation(id, compensation);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Error updating compensation: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Compensation>> getAllCompensations() {
        return ResponseEntity.ok(service.getAllCompensations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCompensationById(@PathVariable Long id) {
        try {
            Compensation comp = service.getCompensationById(id);
            return ResponseEntity.ok(comp);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Error fetching compensation: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompensation(@PathVariable Long id) {
        try {
            service.deleteCompensation(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Error deleting compensation: " + e.getMessage());
        }
    }
}
