package com.hrms.EmployeeManagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeManagementDTO {
    private Long id;
    private String name;
    private String email;
    private String gender;
    private String dob;
    private String joiningDate;
    private String mobile;
    private String aadhar;
    private String accountNumber;
    private String department;
    private String designation;
    private String prevCompany;
    private String pfNumber;
    private String salary;
    private String currentAddress;
    private String permanentAddress;
    private String status;
}
