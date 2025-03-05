package com.hrms.model.PerformanceManagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="general-options")
public class GeneralOption {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="option-name", nullable=false)
	private String optionName;
	
	@Column(name="enabled", nullable=false)
	private boolean enabled = false;

	public GeneralOption(Long id, String optionName, boolean enabled) {
		super();
		this.id = id;
		this.optionName = optionName;
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "GeneralOption [id=" + id + ", optionName=" + optionName + ", enabled=" + enabled + "]";
	}
	
	
	
}
