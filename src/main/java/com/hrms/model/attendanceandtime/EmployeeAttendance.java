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
    private String Name;

    @Column(nullable = false)
    private String clockIn;

    @Column(nullable = false)
    private String clockOut;

    public EmployeeAttendance() {
    }

    public EmployeeAttendance(Long id, String Name, String clockIn, String clockOut) {
        this.id = id;
        this.Name = Name;
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
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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
