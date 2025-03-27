package com.hrms.controller.AttendanceAndTime;

import com.hrms.model.attendanceandtime.Timesheet;
import com.hrms.service.AttendanceAndTime.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timesheets")
@CrossOrigin(origins = "http://localhost:3000")
public class TimesheetController {

    @Autowired
    private TimesheetService timesheetService;

    @GetMapping
    public List<Timesheet> getAllTimesheets() {
        return timesheetService.getAllTimesheets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Timesheet> getTimesheetById(@PathVariable Long id) {
        Timesheet timesheet = timesheetService.getTimesheetById(id);
        return timesheet != null ? ResponseEntity.ok(timesheet) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Timesheet createTimesheet(@RequestBody Timesheet timesheet) {
        return timesheetService.createTimesheet(timesheet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Timesheet> updateTimesheet(@PathVariable Long id, @RequestBody Timesheet timesheet) {
        Timesheet updatedTimesheet = timesheetService.updateTimesheet(id, timesheet);
        return updatedTimesheet != null ? ResponseEntity.ok(updatedTimesheet) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimesheet(@PathVariable Long id) {
        timesheetService.deleteTimesheet(id);
        return ResponseEntity.noContent().build();
    }
}
