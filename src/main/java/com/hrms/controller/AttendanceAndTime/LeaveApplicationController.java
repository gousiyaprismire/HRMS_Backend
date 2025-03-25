package com.hrms.controller.AttendanceAndTime;

import com.hrms.model.attendanceandtime.LeaveApplication; 
import com.hrms.service.AttendanceAndTime.LeaveApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave-applications")
@CrossOrigin(origins = "http://localhost:3000")
public class LeaveApplicationController {

    private final LeaveApplicationService leaveApplicationService;

    public LeaveApplicationController(LeaveApplicationService leaveApplicationService) {
        this.leaveApplicationService = leaveApplicationService;
    }

    // Get all leave applications
    @GetMapping
    public List<LeaveApplication> getAllLeaveApplications() {
        return leaveApplicationService.getAllLeaveApplications();
    }

    // Get only pending leave applications
    @GetMapping("/pending")
    public List<LeaveApplication> getAllPendingLeaveApplications() {
        return leaveApplicationService.getPendingLeaveApplications();
    }

    // Get a leave application by ID
    @GetMapping("/{id}")
    public LeaveApplication getLeaveApplicationById(@PathVariable Long id) {
        return leaveApplicationService.getLeaveApplicationById(id);
    }

    // Create a new leave application
    @PostMapping
    public LeaveApplication createLeaveApplication(@RequestBody LeaveApplication leaveApplication) {
        return leaveApplicationService.createLeaveApplication(leaveApplication);
    }

    // Update leave application details
    @PutMapping("/{id}")
    public LeaveApplication updateLeaveApplication(@PathVariable Long id, @RequestBody LeaveApplication leaveApplication) {
        return leaveApplicationService.updateLeaveApplication(id, leaveApplication);
    }

    // Update leave status (Approve or Reject)
    @PutMapping("/updateStatus/{id}")
    public LeaveApplication updateLeaveStatus(@PathVariable Long id, @RequestParam String status) {
        return leaveApplicationService.updateLeaveStatus(id, status);
    }

    // Delete a leave application
    @DeleteMapping("/{id}")
    public void deleteLeaveApplication(@PathVariable Long id) {
        leaveApplicationService.deleteLeaveApplication(id);
    }
}
