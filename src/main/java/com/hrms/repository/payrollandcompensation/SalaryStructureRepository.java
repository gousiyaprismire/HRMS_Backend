package com.hrms.repository.payrollandcompensation;

import com.hrms.model.payrollandcompensation.SalaryStructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryStructureRepository extends JpaRepository<SalaryStructureEntity, String> {
    // Custom query methods (if needed) can be added here
}
