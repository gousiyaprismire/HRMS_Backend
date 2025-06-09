package com.hrms.RelievingLetter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;


@Entity
@AllArgsConstructor
@Table(name = "relieving_letters")
public class RelievingLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;
    private String designation;
    private String joiningDate; 
    private String relievingDate;
    private String email; 
    
    private String address;

    public RelievingLetter() {
    }

    public RelievingLetter(String employeeName, String designation, String joiningDate, String relievingDate, String email, String address) {
        this.employeeName = employeeName;
        this.designation = designation;
        this.joiningDate = joiningDate;
        this.relievingDate = relievingDate;
        this.email = email;
        this.address = address;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getRelievingDate() {
		return relievingDate;
	}

	public void setRelievingDate(String relievingDate) {
		this.relievingDate = relievingDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "RelievingLetter [id=" + id + ", employeeName=" + employeeName + ", designation=" + designation
				+ ", joiningDate=" + joiningDate + ", relievingDate=" + relievingDate + ", email=" + email
				+ ", address=" + address + "]";
	}

	
    
}
