package com.hrms.serviceImplimentation.payrollandcompensation;

import com.hrms.model.payrollandcompensation.SalaryStructureEntity;
import com.hrms.repository.payrollandcompensation.SalaryStructureRepository;
import com.hrms.service.payrollandcompensation.SalaryStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SalaryStructureServiceImpl implements SalaryStructureService {

    @Autowired
    private SalaryStructureRepository salaryStructureRepository;

    @Override
    public SalaryStructureEntity saveSalaryStructure(SalaryStructureEntity entity) {
        return salaryStructureRepository.save(entity);
    }

    @Override
    public SalaryStructureEntity getSalaryStructureById(String empId) {
        return salaryStructureRepository.findById(empId).orElse(null);
    }

    @Override
    public List<SalaryStructureEntity> getAllSalaryStructures() {
        return salaryStructureRepository.findAll();
    }

    @Override
    public void deleteSalaryStructureById(String empId) {
        salaryStructureRepository.deleteById(empId);
    }
    
}
