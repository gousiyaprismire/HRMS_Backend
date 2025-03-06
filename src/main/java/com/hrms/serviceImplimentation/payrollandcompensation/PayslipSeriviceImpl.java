package com.hrms.serviceImplimentation.payrollandcompensation;

import com.hrms.model.payrollandcompensation.PayslipEntity;
import com.hrms.repository.payrollandcompensation.PayslipRepository;
import com.hrms.service.payrollandcompensation.PayslipService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PayslipSeriviceImpl implements PayslipService {

    private final PayslipRepository payslipRepository;

    public PayslipSeriviceImpl(PayslipRepository payslipRepository) {
        this.payslipRepository = payslipRepository;
    }

    @Override
    public List<PayslipEntity> getAllPayslips() {
        return payslipRepository.findAll();
    }

    @Override
    public Optional<PayslipEntity> getPayslipById(Long id) {
        return payslipRepository.findById(id);
    }

    @Override
    public PayslipEntity createPayslip(PayslipEntity payslip) {
        return payslipRepository.save(payslip);
    }

    @Override
    public PayslipEntity updatePayslip(Long id, PayslipEntity payslip) {
        if (payslipRepository.existsById(id)) {
            payslip.setId(id);
            return payslipRepository.save(payslip);
        }
        throw new RuntimeException("Payslip not found");
    }

    @Override
    public void deletePayslip(Long id) {
        payslipRepository.deleteById(id);
    }
}
