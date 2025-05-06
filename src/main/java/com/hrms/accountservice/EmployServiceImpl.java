package com.hrms.accountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.accountrepo.EmployRepo;
import com.hrms.entity.Employ;

import java.util.List;
import java.util.Optional;

@Service
public class EmployServiceImpl implements EmployService {

    @Autowired
    private EmployRepo employeeRepository;

    @Override
    public Employ saveEmployee(Employ employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employ> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employ> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employ updateEmployee(Long id, Employ employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id); // Ensure the ID is updated correctly
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
