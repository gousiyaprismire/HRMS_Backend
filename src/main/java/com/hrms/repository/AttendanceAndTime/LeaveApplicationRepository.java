package com.hrms.repository.AttendanceAndTime;

import com.hrms.model.attendanceandtime.LeaveApplication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Long> {

	List<LeaveApplication> findByStatus(String status);
}
 