package com.hrms.controller.payrollandcompensation;

import com.hrms.model.payrollandcompensation.SalaryStructureEntity;
import com.hrms.service.payrollandcompensation.SalaryStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary-structure")
@CrossOrigin(origins = "*")
public class SalaryStructure {
 
    @Autowired
    private SalaryStructureService salaryStructureService;

    @PostMapping("/save")
    public ResponseEntity<SalaryStructureEntity> saveSalaryStructure(@RequestBody SalaryStructureEntity salaryStructure) {
        return ResponseEntity.ok(salaryStructureService.saveSalaryStructure(salaryStructure));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaryStructureEntity> getSalaryStructureById(@PathVariable String id) {
        return ResponseEntity.ok(salaryStructureService.getSalaryStructureById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SalaryStructureEntity>> getAllSalaryStructures() {
        return ResponseEntity.ok(salaryStructureService.getAllSalaryStructures());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSalaryStructureById(@PathVariable String id) {
        salaryStructureService.deleteSalaryStructureById(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
