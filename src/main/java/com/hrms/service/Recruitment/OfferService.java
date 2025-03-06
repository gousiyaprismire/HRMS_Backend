package com.hrms.service.Recruitment;


import com.hrms.model.Recruitment.Offer;
import com.hrms.repository.Recruitment.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public Offer generateOffer(Offer offer) {
        offer.setIssuedDate(LocalDateTime.now());
        offer.setStatus("PENDING");
        return offerRepository.save(offer);
    }

    public Optional<Offer> getOfferById(Long id) {
        return offerRepository.findById(id);
    }

    public Optional<Offer> acceptOffer(Long id) {
        Optional<Offer> offerOptional = offerRepository.findById(id);
        if (offerOptional.isPresent()) {
            Offer offer = offerOptional.get();
            offer.setStatus("ACCEPTED");
            return Optional.of(offerRepository.save(offer));
        }
        return Optional.empty();
    }

    public Optional<Offer> rejectOffer(Long id) {
        Optional<Offer> offerOptional = offerRepository.findById(id);
        if (offerOptional.isPresent()) {
            Offer offer = offerOptional.get();
            offer.setStatus("REJECTED");
            return Optional.of(offerRepository.save(offer));
        }
        return Optional.empty();
    }
}
