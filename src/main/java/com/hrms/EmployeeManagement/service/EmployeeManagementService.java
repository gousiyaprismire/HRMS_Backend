package com.hrms.EmployeeManagement.service;

import com.hrms.EmployeeManagement.dto.EmployeeManagementDTO;

import java.util.List;

public interface EmployeeManagementService {
    List<EmployeeManagementDTO> getAllEmployees();
    EmployeeManagementDTO getEmployeeById(Long id);
    EmployeeManagementDTO createEmployee(EmployeeManagementDTO dto);
    EmployeeManagementDTO updateEmployee(Long id, EmployeeManagementDTO dto);
    void deleteEmployee(Long id);
}
