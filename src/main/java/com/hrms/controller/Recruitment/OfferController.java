package com.hrms.controller.Recruitment;

import com.hrms.model.Recruitment.Offer;
import com.hrms.service.Recruitment.OfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public ResponseEntity<Offer> generateOffer(@RequestBody Offer offer) {
        Offer newOffer = offerService.generateOffer(offer);
        return ResponseEntity.ok(newOffer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable Long id) {
        return offerService.getOfferById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/accept")
    public ResponseEntity<Offer> acceptOffer(@PathVariable Long id) {
        Optional<Offer> updatedOffer = offerService.acceptOffer(id);
        return updatedOffer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<Offer> rejectOffer(@PathVariable Long id) {
        Optional<Offer> updatedOffer = offerService.rejectOffer(id);
        return updatedOffer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
