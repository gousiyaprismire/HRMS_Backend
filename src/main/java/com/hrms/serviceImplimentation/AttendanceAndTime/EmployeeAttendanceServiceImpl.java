package com.hrms.serviceImplimentation.AttendanceAndTime;

import com.hrms.model.attendanceandtime.EmployeeAttendance;
import com.hrms.repository.AttendanceAndTime.EmployeeAttendanceRepository;
import com.hrms.service.AttendanceAndTime.EmployeeAttendanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeAttendanceServiceImpl implements EmployeeAttendanceService {

    private final EmployeeAttendanceRepository repository;

    public EmployeeAttendanceServiceImpl(EmployeeAttendanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmployeeAttendance> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public EmployeeAttendance getRecordById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public EmployeeAttendance addRecord(EmployeeAttendance record) {
        return repository.save(record);
    }

    @Override
    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<EmployeeAttendance> searchRecords(String query) {
        return repository.findByNameIgnoreCase(query);
    }
}
