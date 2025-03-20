package com.hrms.model.Recruitment;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interviews")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "candidate_name", nullable = false)
    private String candidateName;

    @Column(name = "job_position", nullable = false)
    private String jobPosition;

    @Column(name = "interview_date", nullable = false)
    private LocalDateTime scheduledTime;

    @Column(name = "interviewer", nullable = false)
    private String interviewerName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Mode mode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.SCHEDULED;

    public Interview() {
    }

    public Interview(String candidateName, String jobPosition, LocalDateTime scheduledTime,
                     String interviewerName, String mode, String status) {
        this.candidateName = candidateName;
        this.jobPosition = jobPosition;
        this.scheduledTime = scheduledTime;
        this.interviewerName = interviewerName;
        this.mode = Mode.valueOf(mode.toUpperCase());
        this.status = Status.valueOf(status.toUpperCase());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setMode(String mode) {
        this.mode = Mode.valueOf(mode.toUpperCase());
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status.toUpperCase());
    }

    public enum Mode {
        ONLINE, OFFLINE
    }

    public enum Status {
        SCHEDULED, COMPLETED, CANCELLED
    }
}
