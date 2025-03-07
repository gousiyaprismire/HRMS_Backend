package com.hrms.EmployeeManagement.repository;

import com.hrms.EmployeeManagement.model.EmployeeManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeManagementRepository extends JpaRepository<EmployeeManagement, Long> {
}
