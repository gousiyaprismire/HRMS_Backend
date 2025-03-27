package com.hrms.repository.AttendanceAndTime;

import com.hrms.model.attendanceandtime.LeaveApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeaveApprovalRepository extends JpaRepository<LeaveApproval, Long> {
    List<LeaveApproval> findByStatus(LeaveApproval.LeaveStatus status);
}
 