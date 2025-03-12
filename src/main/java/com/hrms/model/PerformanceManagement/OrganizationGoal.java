package com.hrms.model.PerformanceManagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name="organization_goals")
public class OrganizationGoal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column( name="period", nullable=false)
	private String period;
	
	
    @Column(name = "goalDescription", nullable = false)
	private String goalDescription;
	
	@Column(name="target", nullable=false)
	private String target;
	
	@Column(name="rollupMethod")
	private String rollupMethod;

	public OrganizationGoal(Long id, String period, String goalDescription, String target, String rollupMethod) {
		super();
		this.id = id;
		this.period = period;
		this.goalDescription = goalDescription;
		this.target = target;
		this.rollupMethod = rollupMethod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getGoalDescription() {
		return goalDescription;
	}

	public void setGoalDescription(String goalDescription) {
		this.goalDescription = goalDescription;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getRollupMethod() {
		return rollupMethod;
	}

	public void setRollupMethod(String rollupMethod) {
		this.rollupMethod = rollupMethod;
	}

	@Override
	public String toString() {
		return "OrganizationGoal [id=" + id + ", period=" + period + ", goalDescription=" + goalDescription
				+ ", target=" + target + ", rollupMethod=" + rollupMethod + "]";
	}
	
}
