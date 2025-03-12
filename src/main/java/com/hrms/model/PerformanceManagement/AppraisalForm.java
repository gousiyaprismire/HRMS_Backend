package com.hrms.model.PerformanceManagement;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name="appraisal_forms")
public class AppraisalForm {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="employeeName", nullable = false)
	private String employeeName;
	
	@Column(name="managerName", nullable = false)
	private String managerName;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Status status;
	
	@Column(name = "lastAction", nullable = false)
    private java.time.LocalDate lastAction;
    
    public enum Status {
        PENDING, APPROVED, REJECTED
    }

	public AppraisalForm(Long id, String employeeName, String managerName, Status status, LocalDate lastAction) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.managerName = managerName;
		this.status = status;
		this.lastAction = lastAction;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public java.time.LocalDate getLastAction() {
		return lastAction;
	}

	public void setLastAction(java.time.LocalDate lastAction) {
		this.lastAction = lastAction;
	}

	@Override
	public String toString() {
		return "AppraisalForm [id=" + id + ", employeeName=" + employeeName + ", managerName=" + managerName
				+ ", status=" + status + ", lastAction=" + lastAction + "]";
	}
    
}
