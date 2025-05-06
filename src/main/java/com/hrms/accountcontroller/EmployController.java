package com.hrms.accountcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hrms.accountservice.EmployService;
import com.hrms.entity.Employ;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployController {

    @Autowired
    private EmployService employeeService;

    
    @PostMapping
    public ResponseEntity<Employ> createEmployee(@RequestBody Employ employee) {
        Employ createdEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(createdEmployee);
    }

    
    @GetMapping
    public ResponseEntity<List<Employ>> getAllEmployees() {
        List<Employ> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Employ> getEmployeeById(@PathVariable Long id) {
        Optional<Employ> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Employ> updateEmployee(@PathVariable Long id, @RequestBody Employ employee) {
        Employ updatedEmployee = employeeService.updateEmployee(id, employee);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
