package com.hrms.controller.payrollandcompensation;

import com.hrms.model.payrollandcompensation.BonusesEntity;
import com.hrms.service.payrollandcompensation.BonusesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bonuses")
@CrossOrigin(origins = "*")
public class BonusesController {

    private final BonusesService bonusesService;

    public BonusesController(BonusesService bonusesService) {
        this.bonusesService = bonusesService;
    }

    @GetMapping("/all")
    public List<BonusesEntity> getAllBonuses() {
        return bonusesService.getAllBonuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BonusesEntity> getBonusById(@PathVariable Long id) {
        Optional<BonusesEntity> bonus = bonusesService.getBonusById(id);
        return bonus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public BonusesEntity createBonus(@RequestBody BonusesEntity bonus) {
        return bonusesService.createBonus(bonus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BonusesEntity> updateBonus(@PathVariable Long id, @RequestBody BonusesEntity bonus) {
        try {
            return ResponseEntity.ok(bonusesService.updateBonus(id, bonus));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBonus(@PathVariable Long id) {
        bonusesService.deleteBonus(id);
        return ResponseEntity.noContent().build();
    }
}
