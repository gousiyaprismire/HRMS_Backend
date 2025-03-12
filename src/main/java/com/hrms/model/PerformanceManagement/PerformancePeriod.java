package com.hrms.model.PerformanceManagement;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="performance_periods")
public class PerformancePeriod {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(name="periodName", nullable=false, length=255)
	private String periodName;
	
	@Column(name="startDate", nullable=false)
	private LocalDate startDate;
	
	@Column(name="endDate", nullable = false)
	private LocalDate endDate;

	public PerformancePeriod(Long id, String periodName, LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.periodName = periodName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPeriodName() {
		return periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "PerformancePeriod [id=" + id + ", periodName=" + periodName + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	
	
}
