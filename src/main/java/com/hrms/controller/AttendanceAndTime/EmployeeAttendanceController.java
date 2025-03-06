package com.hrms.controller.AttendanceAndTime;

import com.hrms.model.attendanceandtime.EmployeeAttendance;
import com.hrms.service.AttendanceAndTime.EmployeeAttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
public class EmployeeAttendanceController {

    private final EmployeeAttendanceService service;

    public EmployeeAttendanceController(EmployeeAttendanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeAttendance> getAllRecords() {
        return service.getAllRecords();
    }

    @GetMapping("/{id}")
    public EmployeeAttendance getRecordById(@PathVariable Long id) {
        return service.getRecordById(id);
    }

    @PostMapping
    public EmployeeAttendance addRecord(@RequestBody EmployeeAttendance record) {
        return service.addRecord(record);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
    }

    @GetMapping("/search")
    public List<EmployeeAttendance> searchRecords(@RequestParam String query) {
        return service.searchRecords(query);
    }
}
