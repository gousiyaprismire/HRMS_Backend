package com.hrms.accountservice;

import java.util.List;
import java.util.Optional;

import com.hrms.entity.Employ;

public interface EmployService {
    Employ saveEmployee(Employ employee);
    List<Employ> getAllEmployees();
    Optional<Employ> getEmployeeById(Long id);
    Employ updateEmployee(Long id, Employ employee);
    void deleteEmployee(Long id);
}
