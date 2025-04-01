package com.hrms.service.Recruitment;


import com.hrms.model.Recruitment.Employee;
import com.hrms.repository.Recruitment.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees");
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        logger.info("Fetching employee with ID: {}", id);
        return employeeRepository.findById(id);
    }

    public Employee addEmployee(Employee employee) {
        logger.info("Adding new employee: {}", employee.getFullName());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        logger.info("Updating employee with ID: {}", id);
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFullName(updatedEmployee.getFullName());
                    employee.setEmail(updatedEmployee.getEmail());
                    employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
                    employee.setJobRole(updatedEmployee.getJobRole());
                    employee.setDepartment(updatedEmployee.getDepartment());
                    employee.setReportingManager(updatedEmployee.getReportingManager());
                    employee.setWorkLocation(updatedEmployee.getWorkLocation());
                    employee.setJoiningDate(updatedEmployee.getJoiningDate());
                    logger.info("Employee updated successfully: {}", id);
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));
    }

    public void deleteEmployee(Long id) {
        logger.info("Attempting to delete employee with ID: {}", id);
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee with ID " + id + " not found");
        }
        employeeRepository.deleteById(id);
        logger.info("Employee deleted successfully: {}", id);
    }

    public Employee updateEmployeeStatus(Long id, String status) {
        return null;
    }
}
