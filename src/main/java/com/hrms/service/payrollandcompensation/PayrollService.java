package com.hrms.service.payrollandcompensation;

import com.hrms.model.payrollandcompensation.PayrollEntity;
import java.util.List;

public interface PayrollService {
    PayrollEntity savePayroll(PayrollEntity payroll);
    List<PayrollEntity> getAllPayrolls();
    PayrollEntity getPayrollById(String empId);
    List<PayrollEntity> getPayrollByMonthAndYear(String month, String year);
    PayrollEntity updatePayroll(String empId, PayrollEntity payroll);
    void deletePayroll(String empId);
}
