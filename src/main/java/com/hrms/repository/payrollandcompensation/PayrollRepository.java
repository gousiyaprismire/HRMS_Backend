package com.hrms.repository.payrollandcompensation;

import com.hrms.model.payrollandcompensation.PayrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PayrollRepository extends JpaRepository<PayrollEntity, String> {
    List<PayrollEntity> findByMonthAndYear(String month, String year);
}
