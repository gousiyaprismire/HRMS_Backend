package com.hrms.repository.payrollandcompensation;

import com.hrms.model.payrollandcompensation.BonusesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BonusesRepository extends JpaRepository<BonusesEntity, Long> {
    List<BonusesEntity> findByMonthAndYear(String month, String year);
}
