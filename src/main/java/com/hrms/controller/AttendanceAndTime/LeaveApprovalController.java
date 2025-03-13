package com.hrms.controller.AttendanceAndTime;

import com.hrms.model.attendanceandtime.LeaveApproval;
import com.hrms.service.AttendanceAndTime.LeaveApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave-approval")
@CrossOrigin("*")
public class LeaveApprovalController {

    @Autowired
    private LeaveApprovalService leaveApprovalService;

    @GetMapping("/pending")
    public List<LeaveApproval> getAllPendingLeaveRequests() {
        return leaveApprovalService.getAllPendingLeaveRequests();
    }

    @GetMapping("/{id}")
    public LeaveApproval getLeaveRequestById(@PathVariable Long id) {
        return leaveApprovalService.getLeaveRequestById(id);
    }

    @PutMapping("/updateStatus/{id}")
    public LeaveApproval updateLeaveStatus(@PathVariable Long id, @RequestParam String status) {
        return leaveApprovalService.updateLeaveStatus(id, status);
    }
}
