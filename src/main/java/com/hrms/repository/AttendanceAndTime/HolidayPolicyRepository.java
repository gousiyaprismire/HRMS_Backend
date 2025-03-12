package com.hrms.repository.AttendanceAndTime;

import com.hrms.model.attendanceandtime.HolidayPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayPolicyRepository extends JpaRepository<HolidayPolicy, Long> {
}
