package com.hrms.serviceImplimentation.payrollandcompensation;

import org.springframework.stereotype.Service;

import com.hrms.model.payrollandcompensation.Compensation;
import com.hrms.repository.payrollandcompensation.CompensationRepository;
import com.hrms.service.payrollandcompensation.CompensationService;

import java.util.List;
import java.util.Optional;

@Service
public class CompensationServiceImpl implements CompensationService {

    private final CompensationRepository repository;

    public CompensationServiceImpl(CompensationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Compensation saveCompensation(Compensation comp) {
        calculateBreakdown(comp);
        return repository.save(comp);
    }

    @Override
    public Compensation updateCompensation(Long id, Compensation comp) {
        Optional<Compensation> existing = repository.findById(id);
        if (existing.isPresent()) {
            Compensation record = existing.get();
            comp.setId(record.getId()); // ensure ID is preserved
            calculateBreakdown(comp);
            return repository.save(comp);
        } else {
            throw new RuntimeException("Compensation not found for ID: " + id);
        }
    }

    @Override
    public List<Compensation> getAllCompensations() {
        return repository.findAll();
    }

    @Override
    public Compensation getCompensationById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compensation not found with ID: " + id));
    }

    @Override
    public void deleteCompensation(Long id) {
        repository.deleteById(id);
    }

    private void calculateBreakdown(Compensation comp) {
        double ctc = comp.getCtc();

        double basic = ctc * 0.50;
        double hra = ctc * 0.20;
        double conveyance = ctc * 0.048;
        double medical = ctc * 0.045;
        double employerPf = basic * 0.06;
        double special = ctc - (basic + hra + conveyance + medical + employerPf);

        double employeePf = employerPf;
        double professionalTax = 2400.0;
        double variablePay = 0;	
        double totalDeductions = employeePf + professionalTax + variablePay;

        double netTakeHome = ctc - totalDeductions;

        comp.setBasicPay(basic);
        comp.setHra(hra);
        comp.setConveyanceAllowance(conveyance);
        comp.setMedicalAllowance(medical);
        comp.setSpecialAllowance(special);
        comp.setEmployerPf(employerPf);
        comp.setEmployeePf(employeePf);
        comp.setProfessionalTax(professionalTax);
        comp.setVariablePay(variablePay);
        comp.setTotalDeductions(totalDeductions);
        comp.setNetTakeHome(netTakeHome);
    }
}
