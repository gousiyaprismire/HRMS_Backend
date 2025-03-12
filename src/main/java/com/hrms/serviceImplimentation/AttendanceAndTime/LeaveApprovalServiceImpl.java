package com.hrms.serviceImplimentation.AttendanceAndTime;

import com.hrms.model.attendanceandtime.LeaveApproval;
import com.hrms.repository.AttendanceAndTime.LeaveApprovalRepository;
import com.hrms.service.AttendanceAndTime.LeaveApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaveApprovalServiceImpl implements LeaveApprovalService {

    @Autowired
    private LeaveApprovalRepository leaveApprovalRepository;

    @Override
    public List<LeaveApproval> getAllPendingLeaveRequests() {
        return leaveApprovalRepository.findByStatus(LeaveApproval.LeaveStatus.Pending);
    }

    @Override
    public LeaveApproval getLeaveRequestById(Long id) {
        return leaveApprovalRepository.findById(id).orElse(null);
    }

    @Override
    public LeaveApproval updateLeaveStatus(Long id, String status) {
        LeaveApproval leaveApproval = leaveApprovalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Leave request not found"));

        try {
            LeaveApproval.LeaveStatus leaveStatus = LeaveApproval.LeaveStatus.valueOf(status);
            leaveApproval.setStatus(leaveStatus);
            return leaveApprovalRepository.save(leaveApproval);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid leave status: " + status);
        }
    }
}
