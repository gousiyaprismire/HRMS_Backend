package com.hrms.service.AttendanceAndTime;

import com.hrms.model.attendanceandtime.EmployeeAttendance;
import java.util.List;

public interface EmployeeAttendanceService {
    List<EmployeeAttendance> getAllRecords();
    EmployeeAttendance getRecordById(Long id);
    EmployeeAttendance addRecord(EmployeeAttendance record);
    void deleteRecord(Long id);
    List<EmployeeAttendance> searchRecords(String query);
}
