package com.hrms.service.AttendanceAndTime;

import com.hrms.model.attendanceandtime.LeaveApproval;
import java.util.List;

public interface LeaveApprovalService {
    List<LeaveApproval> getAllPendingLeaveRequests();
    LeaveApproval getLeaveRequestById(Long id);
    LeaveApproval updateLeaveStatus(Long id, String status);
}
