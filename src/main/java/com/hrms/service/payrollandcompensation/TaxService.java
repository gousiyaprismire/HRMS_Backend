package com.hrms.service.payrollandcompensation;

import com.hrms.model.payrollandcompensation.TaxEntity;
import java.util.List;

public interface TaxService {
    List<TaxEntity> getAllTaxReports();
    TaxEntity getTaxReportById(String empId);
    TaxEntity saveTaxReport(TaxEntity taxReport);
    TaxEntity updateTaxReport(String empId, TaxEntity taxReport);
    void deleteTaxReport(String empId);
}
