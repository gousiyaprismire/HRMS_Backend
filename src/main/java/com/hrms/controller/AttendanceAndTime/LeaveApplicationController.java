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

    @GetMapping
    public List<LeaveApplication> getAllLeaveApplications() {
        return leaveApplicationService.getAllLeaveApplications();
    }

    @GetMapping("/pending")
    public List<LeaveApplication> getAllPendingLeaveApplications() {
        return leaveApplicationService.getPendingLeaveApplications();
    }

    @GetMapping("/{id}")
    public LeaveApplication getLeaveApplicationById(@PathVariable Long id) {
        return leaveApplicationService.getLeaveApplicationById(id);
    }

    @PostMapping
    public LeaveApplication createLeaveApplication(@RequestBody LeaveApplication leaveApplication) {
        return leaveApplicationService.createLeaveApplication(leaveApplication);
    }

    @PutMapping("/{id}")
    public LeaveApplication updateLeaveApplication(@PathVariable Long id, @RequestBody LeaveApplication leaveApplication) {
        return leaveApplicationService.updateLeaveApplication(id, leaveApplication);
    }

    @PutMapping("/updateStatus/{id}")
    public LeaveApplication updateLeaveStatus(@PathVariable Long id, @RequestParam String status) {
        return leaveApplicationService.updateLeaveStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteLeaveApplication(@PathVariable Long id) {
        leaveApplicationService.deleteLeaveApplication(id);
    }
}
