package com.hrms.serviceImplimentation.payrollandcompensation;

import com.hrms.model.payrollandcompensation.TaxEntity;
import com.hrms.repository.payrollandcompensation.TaxRepository;
import com.hrms.service.payrollandcompensation.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxServiceImpl implements TaxService {

    @Autowired
    private TaxRepository taxRepository;

    @Override
    public List<TaxEntity> getAllTaxReports() {
        return taxRepository.findAll();
    }

    @Override
    public TaxEntity getTaxReportById(String empId) {
        return taxRepository.findById(empId).orElse(null);
    }

    @Override
    public TaxEntity saveTaxReport(TaxEntity taxReport) {
        return taxRepository.save(taxReport);
    }

    @Override
    public TaxEntity updateTaxReport(String empId, TaxEntity taxReport) {
        Optional<TaxEntity> existingReport = taxRepository.findById(empId);
        if (existingReport.isPresent()) {
            TaxEntity updatedReport = existingReport.get();
            updatedReport.setName(taxReport.getName());
            updatedReport.setProvidentFund(taxReport.getProvidentFund());
            updatedReport.setInsurance(taxReport.getInsurance());
            updatedReport.setDeductions(taxReport.getDeductions());
            updatedReport.setMonth(taxReport.getMonth());
            updatedReport.setYear(taxReport.getYear());
            return taxRepository.save(updatedReport);
        }
        return null;
    }

    @Override
    public void deleteTaxReport(String empId) {
        taxRepository.deleteById(empId);
    }
}
