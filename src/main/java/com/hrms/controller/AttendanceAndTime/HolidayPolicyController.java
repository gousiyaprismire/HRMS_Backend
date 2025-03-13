package com.hrms.controller.AttendanceAndTime;

import com.hrms.model.attendanceandtime.HolidayPolicy;
import com.hrms.service.AttendanceAndTime.HolidayPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holidays")
@CrossOrigin("*")
public class HolidayPolicyController {

    @Autowired
    private HolidayPolicyService holidayPolicyService;

    @GetMapping
    public List<HolidayPolicy> getAllHolidays() {
        return holidayPolicyService.getAllHolidays();
    }

    @PostMapping
    public HolidayPolicy addHoliday(@RequestBody HolidayPolicy holiday) {
        return holidayPolicyService.addHoliday(holiday);
    }
}
