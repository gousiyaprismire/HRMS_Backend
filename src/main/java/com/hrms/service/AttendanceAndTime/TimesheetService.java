package com.hrms.service.AttendanceAndTime;

import com.hrms.model.attendanceandtime.Timesheet;
import java.util.List;

public interface TimesheetService {
    List<Timesheet> getAllTimesheets();
    Timesheet getTimesheetById(Long id);
    Timesheet createTimesheet(Timesheet timesheet);
    Timesheet updateTimesheet(Long id, Timesheet timesheet);
    void deleteTimesheet(Long id);
}
