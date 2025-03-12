package com.hrms.serviceImplimentation.AttendanceAndTime;

import com.hrms.model.attendanceandtime.HolidayPolicy;
import com.hrms.repository.AttendanceAndTime.HolidayPolicyRepository;
import com.hrms.service.AttendanceAndTime.HolidayPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayPolicyServiceImpl implements HolidayPolicyService {

    @Autowired
    private HolidayPolicyRepository holidayPolicyRepository;

    @Override
    public List<HolidayPolicy> getAllHolidays() {
        return holidayPolicyRepository.findAll();
    }

    @Override
    public HolidayPolicy addHoliday(HolidayPolicy holiday) {
        return holidayPolicyRepository.save(holiday);
    }
}
