package com.hrms.controller.Recruitment;


import com.hrms.BenefitsCompliance.dto.OfferLetterRequest;
import com.hrms.model.Recruitment.OfferLetter;
import com.hrms.service.Recruitment.OfferLetterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offer-letters")
@CrossOrigin(origins = "http://localhost:3000")
public class OfferLetterController {
    private final OfferLetterService service;

    public OfferLetterController(OfferLetterService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<OfferLetter> createOfferLetter(@Valid @RequestBody OfferLetterRequest request) {
        return ResponseEntity.ok(service.saveOfferLetter(request));
    }


    @GetMapping
    public ResponseEntity<List<OfferLetter>> getAllOfferLetters() {
        return ResponseEntity.ok(service.getAllOfferLetters());
    }


    @GetMapping("/{id}")
    public ResponseEntity<OfferLetter> getOfferLetterById(@PathVariable Long id) {
        Optional<OfferLetter> offerLetter = service.getOfferLetterById(id);
        return offerLetter.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferLetter> updateOfferLetter(@PathVariable Long id,
                                                         @Valid @RequestBody OfferLetterRequest request) {
        Optional<OfferLetter> updatedOfferLetter = service.updateOfferLetter(id, request);
        return updatedOfferLetter.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
