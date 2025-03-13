package com.hrms.service.AttendanceAndTime;

import com.hrms.model.attendanceandtime.HolidayPolicy;
import java.util.List;

public interface HolidayPolicyService {
    List<HolidayPolicy> getAllHolidays();
    HolidayPolicy addHoliday(HolidayPolicy holiday);
}
