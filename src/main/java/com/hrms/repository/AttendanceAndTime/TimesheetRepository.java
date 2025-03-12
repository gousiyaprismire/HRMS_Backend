package com.hrms.repository.AttendanceAndTime;

import com.hrms.model.attendanceandtime.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
}
