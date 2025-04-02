package com.hrms.service.Recruitment;

import com.hrms.BenefitsCompliance.dto.OfferLetterRequest;
import com.hrms.model.Recruitment.OfferLetter;
import com.hrms.repository.Recruitment.OfferLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferLetterService {
    private final OfferLetterRepository offerLetterRepository;

    @Autowired
    public OfferLetterService(OfferLetterRepository offerLetterRepository) {
        this.offerLetterRepository = offerLetterRepository;
    }

    public OfferLetter saveOfferLetter(OfferLetterRequest request) {
        OfferLetter offerLetter = new OfferLetter(
                request.getCandidateEmail(),
                request.getCandidateName(),
                request.getEmploymentType(),
                request.getHrContactPerson(),
                request.getJobPosition(),
                request.getOfferDate(),
                request.getPhoneNumber(),
                request.getSalaryPackage(),
                request.getStatus(),
                request.getWorkLocation()
        );
        return offerLetterRepository.save(offerLetter);
    }

    public List<OfferLetter> getAllOfferLetters() {
        return offerLetterRepository.findAll();
    }

    public Optional<OfferLetter> getOfferLetterById(Long id) {
        return offerLetterRepository.findById(id);
    }

    public Optional<OfferLetter> updateOfferLetter(Long id, OfferLetterRequest request) {
        return offerLetterRepository.findById(id).map(existingOffer -> {
            existingOffer.setCandidateEmail(request.getCandidateEmail());
            existingOffer.setCandidateName(request.getCandidateName());
            existingOffer.setEmploymentType(request.getEmploymentType());
            existingOffer.setHrContactPerson(request.getHrContactPerson());
            existingOffer.setJobPosition(request.getJobPosition());
            existingOffer.setOfferDate(request.getOfferDate());
            existingOffer.setPhoneNumber(request.getPhoneNumber());
            existingOffer.setSalaryPackage(request.getSalaryPackage());
            existingOffer.setStatus(request.getStatus());
            existingOffer.setWorkLocation(request.getWorkLocation());
            return offerLetterRepository.save(existingOffer);
        });
    }

    public void deleteOfferLetter(Long id) {
        offerLetterRepository.deleteById(id);
    }
}
