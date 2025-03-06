package com.hrms.service.payrollandcompensation;

import com.hrms.model.payrollandcompensation.PayslipEntity;
import java.util.List;
import java.util.Optional;

public interface PayslipService {
    List<PayslipEntity> getAllPayslips();
    Optional<PayslipEntity> getPayslipById(Long id);
    PayslipEntity createPayslip(PayslipEntity payslip);
    PayslipEntity updatePayslip(Long id, PayslipEntity payslip);
    void deletePayslip(Long id);
}
