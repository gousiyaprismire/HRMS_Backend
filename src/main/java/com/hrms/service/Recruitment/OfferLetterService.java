package com.hrms.service.Recruitment;



import com.hrms.BenefitsCompliance.dto.OfferLetterRequest;
import com.hrms.model.Recruitment.OfferLetter;
import com.hrms.repository.Recruitment.OfferLetterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferLetterService {
    private final OfferLetterRepository repository;

    public OfferLetterService(OfferLetterRepository repository) {
        this.repository = repository;
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
        return repository.save(offerLetter);
    }


    public List<OfferLetter> getAllOfferLetters() {
        return repository.findAll();
    }

    public Optional<OfferLetter> getOfferLetterById(Long id) {
        return repository.findById(id);
    }

    public Optional<OfferLetter> updateOfferLetter(Long id, OfferLetterRequest request) {
        return repository.findById(id).map(existingOffer -> {
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
            return repository.save(existingOffer);
        });
    }
}
