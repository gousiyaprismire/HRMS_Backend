package com.hrms.service.payrollandcompensation;


import java.util.List;

import com.hrms.model.payrollandcompensation.Compensation;

public interface CompensationService {
    Compensation saveCompensation(Compensation compensation);
    Compensation updateCompensation(Long id, Compensation compensation);
    List<Compensation> getAllCompensations();
    Compensation getCompensationById(Long id);
    void deleteCompensation(Long id);
}
