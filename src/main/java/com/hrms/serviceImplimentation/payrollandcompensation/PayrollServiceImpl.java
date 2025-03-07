package com.hrms.serviceImplimentation.payrollandcompensation;

import com.hrms.model.payrollandcompensation.PayrollEntity;
import com.hrms.repository.payrollandcompensation.PayrollRepository;
import com.hrms.service.payrollandcompensation.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Override
    public PayrollEntity savePayroll(PayrollEntity payroll) {
        return payrollRepository.save(payroll);
    }

    @Override
    public List<PayrollEntity> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    @Override
    public PayrollEntity getPayrollById(String empId) {
        return payrollRepository.findById(empId).orElse(null);
    }

    @Override
    public List<PayrollEntity> getPayrollByMonthAndYear(String month, String year) {
        return payrollRepository.findByMonthAndYear(month, year);
    }

    @Override
    public PayrollEntity updatePayroll(String empId, PayrollEntity payroll) {
        Optional<PayrollEntity> existingPayroll = payrollRepository.findById(empId);
        if (existingPayroll.isPresent()) {
            PayrollEntity updatedPayroll = existingPayroll.get();
            updatedPayroll.setName(payroll.getName());
            updatedPayroll.setGrossPay(payroll.getGrossPay());
            updatedPayroll.setNetPay(payroll.getNetPay());
            updatedPayroll.setDeductions(payroll.getDeductions());
            updatedPayroll.setMonth(payroll.getMonth());
            updatedPayroll.setYear(payroll.getYear());
            return payrollRepository.save(updatedPayroll);
        }
        return null;
    }

    @Override
    public void deletePayroll(String empId) {
        payrollRepository.deleteById(empId);
    }
}
