package com.hrms.model.payrollandcompensation;

import jakarta.persistence.*;

@Entity
@Table(name = "compensations")
public class Compensation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String employeeName;
    private Double ctc;

    // Earnings
    private Double basicPay;
    private Double hra;
    private Double conveyanceAllowance;
    private Double medicalAllowance;
    private Double specialAllowance;
    private Double employerPf;

    // Deductions
    private Double employeePf;
    private Double professionalTax;
    private Double variablePay;
    private Double totalDeductions;

    private Double netTakeHome;

    public Compensation() {}

    // Getters and Setters for all fields (truncated for brevity but should be added for each field)
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    
    public Double getCtc() { return ctc; }
    public void setCtc(Double ctc) { this.ctc = ctc; }

    public Double getBasicPay() { return basicPay; }
    public void setBasicPay(Double basicPay) { this.basicPay = basicPay; }

    public Double getHra() { return hra; }
    public void setHra(Double hra) { this.hra = hra; }

    public Double getConveyanceAllowance() { return conveyanceAllowance; }
    public void setConveyanceAllowance(Double conveyanceAllowance) { this.conveyanceAllowance = conveyanceAllowance; }

    public Double getMedicalAllowance() { return medicalAllowance; }
    public void setMedicalAllowance(Double medicalAllowance) { this.medicalAllowance = medicalAllowance; }

    public Double getSpecialAllowance() { return specialAllowance; }
    public void setSpecialAllowance(Double specialAllowance) { this.specialAllowance = specialAllowance; }

    public Double getEmployerPf() { return employerPf; }
    public void setEmployerPf(Double employerPf) { this.employerPf = employerPf; }

    public Double getEmployeePf() { return employeePf; }
    public void setEmployeePf(Double employeePf) { this.employeePf = employeePf; }

    public Double getProfessionalTax() { return professionalTax; }
    public void setProfessionalTax(Double professionalTax) { this.professionalTax = professionalTax; }

    public Double getVariablePay() { return variablePay; }
    public void setVariablePay(Double variablePay) { this.variablePay = variablePay; }

    public Double getTotalDeductions() { return totalDeductions; }
    public void setTotalDeductions(Double totalDeductions) { this.totalDeductions = totalDeductions; }

    public Double getNetTakeHome() { return netTakeHome; }
    public void setNetTakeHome(Double netTakeHome) { this.netTakeHome = netTakeHome; }

	@Override
	public String toString() {
		return "Compensation [id=" + id + ", employeeId=" + employeeId + ", ctc=" + ctc + ", basicPay=" + basicPay
				+ ", hra=" + hra + ", conveyanceAllowance=" + conveyanceAllowance + ", medicalAllowance="
				+ medicalAllowance + ", specialAllowance=" + specialAllowance + ", employerPf=" + employerPf
				+ ", employeePf=" + employeePf + ", professionalTax=" + professionalTax + ", variablePay=" + variablePay
				+ ", totalDeductions=" + totalDeductions + ", netTakeHome=" + netTakeHome + "]";
	}
    
    
}
