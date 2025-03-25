package com.hrms.serviceImplimentation.AttendanceAndTime;

import com.hrms.model.attendanceandtime.LeaveApplication;
import com.hrms.repository.AttendanceAndTime.LeaveApplicationRepository;
import com.hrms.service.AttendanceAndTime.LeaveApplicationService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService {

    private final LeaveApplicationRepository leaveApplicationRepository;

    public LeaveApplicationServiceImpl(LeaveApplicationRepository leaveApplicationRepository) {
        this.leaveApplicationRepository = leaveApplicationRepository;
    }

    @Override
    public List<LeaveApplication> getAllLeaveApplications() {
        return leaveApplicationRepository.findAll();
    }

    @Override
    public LeaveApplication getLeaveApplicationById(Long id) {
        return leaveApplicationRepository.findById(id).orElse(null);
    }

    @Override
    public LeaveApplication createLeaveApplication(LeaveApplication leaveApplication) {
        leaveApplication.setStatus("Pending");
        return leaveApplicationRepository.save(leaveApplication);
    }

    @Override
    public LeaveApplication updateLeaveApplication(Long id, LeaveApplication leaveApplication) {
        Optional<LeaveApplication> existingLeave = leaveApplicationRepository.findById(id);
        if (existingLeave.isPresent()) {
            LeaveApplication updatedLeave = existingLeave.get();
            updatedLeave.setName(leaveApplication.getName());
            updatedLeave.setLeaveType(leaveApplication.getLeaveType());
            updatedLeave.setStartDate(leaveApplication.getStartDate());
            updatedLeave.setEndDate(leaveApplication.getEndDate());
            updatedLeave.setStatus(leaveApplication.getStatus());
            return leaveApplicationRepository.save(updatedLeave);
        }
        return null;
    }

    @Override
    public void deleteLeaveApplication(Long id) {
        leaveApplicationRepository.deleteById(id);
    }

    // **Fetch all pending leave applications**
    @Override
    public List<LeaveApplication> getPendingLeaveApplications() {
        return leaveApplicationRepository.findByStatus("Pending");
    }

    // **Update leave request status (Approve/Reject)**
    @Override
    public LeaveApplication updateLeaveStatus(Long id, String status) {
        Optional<LeaveApplication> leaveApplicationOptional = leaveApplicationRepository.findById(id);
        if (leaveApplicationOptional.isPresent()) {
            LeaveApplication leaveApplication = leaveApplicationOptional.get();
            leaveApplication.setStatus(status);
            return leaveApplicationRepository.save(leaveApplication);
        }
        return null;
    }
}
