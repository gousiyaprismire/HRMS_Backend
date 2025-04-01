package com.hrms.service.Recruitment;

import com.hrms.model.Recruitment.Employee;
import com.hrms.model.Recruitment.Interview;
import com.hrms.repository.Recruitment.EmployeeRepository;
import com.hrms.repository.Recruitment.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;

    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    // ✅ Add this method to fetch an interview by ID
    public Interview getInterviewById(Long id) {
        return interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));
    }

    // ✅ Alternative method that returns Optional
    public Optional<Interview> getInterviewByIdOptional(Long id) {
        return interviewRepository.findById(id);
    }

    public Interview scheduleInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public Interview saveInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public void cancelInterview(Long id) {
        interviewRepository.deleteById(id);
    }

    @Service
    public static class EmployeeService {

        private final EmployeeRepository employeeRepository;

        @Autowired
        public EmployeeService(EmployeeRepository employeeRepository) {
            this.employeeRepository = employeeRepository;
        }

        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        public Optional<Employee> getEmployeeById(Long id) {
            return employeeRepository.findById(id);
        }

        public Employee addEmployee(Employee employee) {
            return employeeRepository.save(employee);
        }

        public Employee updateEmployee(Long id, Employee updatedEmployee) {
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
                        return employeeRepository.save(employee);
                    })
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
        }

        public void deleteEmployee(Long id) {
            employeeRepository.deleteById(id);
        }
    }
}
