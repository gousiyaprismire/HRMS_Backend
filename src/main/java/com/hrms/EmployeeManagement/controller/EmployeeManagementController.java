package com.hrms.EmployeeManagement.controller;

import com.hrms.EmployeeManagement.dto.EmployeeManagementDTO;
import com.hrms.EmployeeManagement.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeManagementController {

    @Autowired
    private EmployeeManagementService service;

    @GetMapping
    public List<EmployeeManagementDTO> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeManagementDTO getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    public EmployeeManagementDTO createEmployee(@RequestBody EmployeeManagementDTO dto) {
        return service.createEmployee(dto);
    }

    @PutMapping("/{id}")
    public EmployeeManagementDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeManagementDTO dto) {
        return service.updateEmployee(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}
