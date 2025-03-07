package com.hrms.repository.payrollandcompensation;

import com.hrms.model.payrollandcompensation.TaxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<TaxEntity, String> {
}
