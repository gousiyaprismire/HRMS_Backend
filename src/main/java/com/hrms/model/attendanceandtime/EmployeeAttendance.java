package com.hrms.model.attendanceandtime;

import jakarta.persistence.*;

@Entity
@Table(name = "attendance_and_time")
public class EmployeeAttendance
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String clockIn;

    @Column(nullable = false)
    private String clockOut;

    public EmployeeAttendance() {
    }

    public EmployeeAttendance(Long id, String name, String clockIn, String clockOut) {
        this.id = id;
        this.name = name;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClockIn() {
        return clockIn;
    }

    public void setClockIn(String clockIn) {
        this.clockIn = clockIn;
    }

    public String getClockOut() {
        return clockOut;
    }

    public void setClockOut(String clockOut) {
        this.clockOut = clockOut;
    }

}
