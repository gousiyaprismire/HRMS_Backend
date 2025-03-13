package com.hrms.serviceImplimentation.AttendanceAndTime;

import com.hrms.model.attendanceandtime.LeavePolicy;
import com.hrms.repository.AttendanceAndTime.LeavePolicyRepository;
import com.hrms.service.AttendanceAndTime.LeavePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeavePolicyServiceImpl implements LeavePolicyService {

    @Autowired
    private LeavePolicyRepository leavePolicyRepository;

    @Override
    public List<LeavePolicy> getAllLeavePolicies() {
        return leavePolicyRepository.findAll();
    }

    @Override
    public LeavePolicy addLeavePolicy(LeavePolicy leavePolicy) {
        return leavePolicyRepository.save(leavePolicy);
    }
}
