package com.hrms.serviceImplimentation.AttendanceAndTime;

import com.hrms.model.attendanceandtime.Timesheet;
import com.hrms.repository.AttendanceAndTime.TimesheetRepository;
import com.hrms.service.AttendanceAndTime.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimesheetServiceImpl implements TimesheetService {

    @Autowired
    private TimesheetRepository timesheetRepository;

    @Override
    public List<Timesheet> getAllTimesheets() {
        return timesheetRepository.findAll();
    }

    @Override
    public Timesheet getTimesheetById(Long id) {
        return timesheetRepository.findById(id).orElse(null);
    }

    @Override
    public Timesheet createTimesheet(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }

    @Override
    public Timesheet updateTimesheet(Long id, Timesheet timesheet) {
        Optional<Timesheet> existingTimesheet = timesheetRepository.findById(id);
        if (existingTimesheet.isPresent()) {
//            timesheet.setId(id);
            return timesheetRepository.save(timesheet);
        }
        return null;
    }

    @Override
    public void deleteTimesheet(Long id) {
        timesheetRepository.deleteById(id);
    }
}
