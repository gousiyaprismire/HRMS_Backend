package com.hrms.EmployeeManagement.service;

import com.hrms.EmployeeManagement.dto.EmployeeManagementDTO;
import com.hrms.EmployeeManagement.exception.EmployeeManagementNotFoundException;
import com.hrms.EmployeeManagement.model.EmployeeManagement;
import com.hrms.EmployeeManagement.repository.EmployeeManagementRepository;
import com.hrms.EmployeeManagement.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

    @Autowired
    private EmployeeManagementRepository repository;

    @Override
    public List<EmployeeManagementDTO> getAllEmployees() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeManagementDTO getEmployeeById(Long id) {
        EmployeeManagement employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeManagementNotFoundException("Employee not found with id: " + id));
        return convertToDTO(employee);
    }

    @Override
    public EmployeeManagementDTO createEmployee(EmployeeManagementDTO dto) {
        EmployeeManagement employee = convertToEntity(dto);
        repository.save(employee);
        return convertToDTO(employee);
    }

    @Override
    public EmployeeManagementDTO updateEmployee(Long id, EmployeeManagementDTO dto) {
        EmployeeManagement existingEmployee = repository.findById(id)
                .orElseThrow(() -> new EmployeeManagementNotFoundException("Employee not found with id: " + id));

        existingEmployee.setName(dto.getName());
        existingEmployee.setEmail(dto.getEmail());
        existingEmployee.setGender(dto.getGender());
        existingEmployee.setDob(dto.getDob());
        existingEmployee.setJoiningDate(dto.getJoiningDate());
        existingEmployee.setMobile(dto.getMobile());
        existingEmployee.setAadhar(dto.getAadhar());
        existingEmployee.setAccountNumber(dto.getAccountNumber());
        existingEmployee.setDepartment(dto.getDepartment());
        existingEmployee.setDesignation(dto.getDesignation());
        existingEmployee.setPrevCompany(dto.getPrevCompany());
        existingEmployee.setPfNumber(dto.getPfNumber());
        existingEmployee.setSalary(dto.getSalary());
        existingEmployee.setCurrentAddress(dto.getCurrentAddress());
        existingEmployee.setPermanentAddress(dto.getPermanentAddress());
        existingEmployee.setStatus(dto.getStatus());

        repository.save(existingEmployee);
        return convertToDTO(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        EmployeeManagement employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeManagementNotFoundException("Employee not found with id: " + id));
        repository.delete(employee);
    }

    private EmployeeManagementDTO convertToDTO(EmployeeManagement employee) {
        return new EmployeeManagementDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getGender(),
                employee.getDob(),
                employee.getJoiningDate(),
                employee.getMobile(),
                employee.getAadhar(),
                employee.getAccountNumber(),
                employee.getDepartment(),
                employee.getDesignation(),
                employee.getPrevCompany(),
                employee.getPfNumber(),
                employee.getSalary(),
                employee.getCurrentAddress(),
                employee.getPermanentAddress(),
                employee.getStatus()
        );
    }

    private EmployeeManagement convertToEntity(EmployeeManagementDTO dto) {
        return new EmployeeManagement(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getGender(),
                dto.getDob(),
                dto.getJoiningDate(),
                dto.getMobile(),
                dto.getAadhar(),
                dto.getAccountNumber(),
                dto.getDepartment(),
                dto.getDesignation(),
                dto.getPrevCompany(),
                dto.getPfNumber(),
                dto.getSalary(),
                dto.getCurrentAddress(),
                dto.getPermanentAddress(),
                dto.getStatus()
        );
    }
}
