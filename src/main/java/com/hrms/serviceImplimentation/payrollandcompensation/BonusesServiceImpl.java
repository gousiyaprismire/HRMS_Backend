package com.hrms.serviceImplimentation.payrollandcompensation;

import com.hrms.model.payrollandcompensation.BonusesEntity;
import com.hrms.repository.payrollandcompensation.BonusesRepository;
import com.hrms.service.payrollandcompensation.BonusesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BonusesServiceImpl implements BonusesService {

    private final BonusesRepository bonusesRepository;

    public BonusesServiceImpl(BonusesRepository bonusesRepository) {
        this.bonusesRepository = bonusesRepository;
    }

    @Override
    public List<BonusesEntity> getAllBonuses() {
        return bonusesRepository.findAll();
    }

    @Override
    public Optional<BonusesEntity> getBonusById(Long id) {
        return bonusesRepository.findById(id);
    }

    @Override
    public BonusesEntity createBonus(BonusesEntity bonus) {
        return bonusesRepository.save(bonus);
    }

    @Override
    public BonusesEntity updateBonus(Long id, BonusesEntity bonus) {
        if (bonusesRepository.existsById(id)) {
            bonus.setId(id);
            return bonusesRepository.save(bonus);
        }
        throw new RuntimeException("Bonus not found");
    }

    @Override
    public void deleteBonus(Long id) {
        bonusesRepository.deleteById(id);
    }
}
