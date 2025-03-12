package com.hrms.controller.AttendanceAndTime;

import com.hrms.model.attendanceandtime.LeavePolicy;
import com.hrms.service.AttendanceAndTime.LeavePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@CrossOrigin("*")
public class LeavePolicyController {

    @Autowired
    private LeavePolicyService leavePolicyService;

    @GetMapping
    public List<LeavePolicy> getAllLeavePolicies() {
        return leavePolicyService.getAllLeavePolicies();
    }

    @PostMapping
    public LeavePolicy addLeavePolicy(@RequestBody LeavePolicy leavePolicy) {
        return leavePolicyService.addLeavePolicy(leavePolicy);
    }
}
