package com.hrms.service.payrollandcompensation;

import com.hrms.model.payrollandcompensation.SalaryStructureEntity;
import java.util.List;

public interface SalaryStructureService {
    SalaryStructureEntity saveSalaryStructure(SalaryStructureEntity entity);
    SalaryStructureEntity getSalaryStructureById(String empId);
    List<SalaryStructureEntity> getAllSalaryStructures();
    void deleteSalaryStructureById(String empId);
}
