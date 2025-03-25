package com.hrms.service.AttendanceAndTime;

import com.hrms.model.attendanceandtime.LeaveApplication;
import java.util.List;

public interface LeaveApplicationService {
    List<LeaveApplication> getAllLeaveApplications();
    LeaveApplication getLeaveApplicationById(Long id);
    LeaveApplication createLeaveApplication(LeaveApplication leaveApplication);
    LeaveApplication updateLeaveApplication(Long id, LeaveApplication leaveApplication);
    void deleteLeaveApplication(Long id);

    // Fetch only pending leave applications
    List<LeaveApplication> getPendingLeaveApplications();
    
    // Update leave status (Approve/Reject)
    LeaveApplication updateLeaveStatus(Long id, String status);
}
