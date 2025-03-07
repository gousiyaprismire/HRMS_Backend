package com.hrms.service.payrollandcompensation;

import com.hrms.model.payrollandcompensation.BonusesEntity;

import java.util.List;
import java.util.Optional;

public interface BonusesService {
    List<BonusesEntity> getAllBonuses();
    Optional<BonusesEntity> getBonusById(Long id);
    BonusesEntity createBonus(BonusesEntity bonus);
    BonusesEntity updateBonus(Long id, BonusesEntity bonus);
    void deleteBonus(Long id);
}
