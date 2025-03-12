package com.hrms.service.AttendanceAndTime;

import com.hrms.model.attendanceandtime.LeavePolicy;
import java.util.List;

public interface LeavePolicyService {
    List<LeavePolicy> getAllLeavePolicies();
    LeavePolicy addLeavePolicy(LeavePolicy leavePolicy);
}
