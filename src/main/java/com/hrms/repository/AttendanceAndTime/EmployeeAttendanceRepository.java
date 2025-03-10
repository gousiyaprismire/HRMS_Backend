package com.hrms.repository.AttendanceAndTime;

import com.hrms.model.attendanceandtime.EmployeeAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance, Long> {
    List<EmployeeAttendance> findByNameIgnoreCase(String name);
}
