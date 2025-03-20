package com.hrms.service.Recruitment;



import com.hrms.model.Recruitment.Offer;

import com.hrms.repository.Recruitment.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    public Optional<Offer> getOfferById(Long id) {
        return offerRepository.findById(id);
    }

    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public Offer updateOffer(Long id, Offer updatedOffer) {
        return offerRepository.findById(id)
                .map(offer -> {
                    offer.setCandidateName(updatedOffer.getCandidateName());
                    offer.setCandidateEmail(updatedOffer.getCandidateEmail());
                    offer.setPhoneNumber(updatedOffer.getPhoneNumber());
                    offer.setJobPosition(updatedOffer.getJobPosition());
                    offer.setSalaryPackage(updatedOffer.getSalaryPackage());
                    offer.setEmploymentType(updatedOffer.getEmploymentType());
                    offer.setWorkLocation(updatedOffer.getWorkLocation());
                    offer.setOfferDate(updatedOffer.getOfferDate());
                    offer.setHrContactPerson(updatedOffer.getHrContactPerson());
                    offer.setStatus(updatedOffer.getStatus());
                    return offerRepository.save(offer);
                }).orElse(null);
    }

    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }
}
