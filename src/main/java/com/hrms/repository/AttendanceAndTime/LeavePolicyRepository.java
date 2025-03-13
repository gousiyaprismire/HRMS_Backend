package com.hrms.repository.AttendanceAndTime;

import com.hrms.model.attendanceandtime.LeavePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeavePolicyRepository extends JpaRepository<LeavePolicy, Long> {
}
