package com.hrms.controller.Recruitment;



import com.hrms.model.Recruitment.Offer;
import com.hrms.service.Recruitment.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }

    @GetMapping("/{id}")
    public Optional<Offer> getOfferById(@PathVariable Long id) {
        return offerService.getOfferById(id);
    }

    @PostMapping
    public Offer createOffer(@RequestBody Offer offer) {
        return offerService.createOffer(offer);
    }

    @PutMapping("/{id}")
    public Offer updateOffer(@PathVariable Long id, @RequestBody Offer offer) {
        return offerService.updateOffer(id, offer);
    }

    @DeleteMapping("/{id}")
    public String deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);
        return "Offer deleted successfully!";
    }
}
