package com.hrms.BenefitsCompliance.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.BenefitsCompliance.dto.ClaimsReimbursementDTO;
import com.hrms.BenefitsCompliance.exception.ClaimsReimbursementNotFoundException;
import com.hrms.BenefitsCompliance.model.ClaimsReimbursement;
import com.hrms.BenefitsCompliance.repository.ClaimsReimbursementRepository;

@Service
public class ClaimsReimbursementServiceImpl implements ClaimsReimbursementService {

    @Autowired
    private ClaimsReimbursementRepository repository;

    @Override
    public ClaimsReimbursementDTO submitClaim(ClaimsReimbursementDTO dto) {
        ClaimsReimbursement claim = convertToEntity(dto);
        repository.save(claim);
        return convertToDTO(claim);
    }

    @Override
    public List<ClaimsReimbursementDTO> getClaimsByEmployeeId(Long employeeId) {
        return repository.findByEmployeeId(employeeId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClaimsReimbursementDTO getClaimById(Long id) {
        ClaimsReimbursement claim = repository.findById(id)
                .orElseThrow(() -> new ClaimsReimbursementNotFoundException("Claim not found with id: " + id));
        return convertToDTO(claim);
    }

    @Override
    public ClaimsReimbursementDTO updateClaim(Long id, ClaimsReimbursementDTO dto) {
        ClaimsReimbursement existingClaim = repository.findById(id)
                .orElseThrow(() -> new ClaimsReimbursementNotFoundException("Claim not found with id: " + id));

//        existingClaim.setClaimType(dto.getClaimType());
//        existingClaim.setClaimAmount(dto.getClaimAmount());
//        existingClaim.setClaimDate(dto.getClaimDate());
//        existingClaim.setStatus(dto.getStatus());
//        existingClaim.setRemarks(dto.getRemarks());

        repository.save(existingClaim);
        return convertToDTO(existingClaim);
    }

    @Override
    public void deleteClaim(Long id) {
        ClaimsReimbursement claim = repository.findById(id)
                .orElseThrow(() -> new ClaimsReimbursementNotFoundException("Claim not found with id: " + id));
        repository.delete(claim);
    }

    private ClaimsReimbursementDTO convertToDTO(ClaimsReimbursement claim) {
        return new ClaimsReimbursementDTO(
//                claim.getId(),
//                claim.getEmployeeId(),
//                claim.getClaimType(),
//                claim.getClaimAmount(),
//                claim.getClaimDate(),
//                claim.getStatus(),
//                claim.getRemarks()
        );
    }

    private ClaimsReimbursement convertToEntity(ClaimsReimbursementDTO dto) {
        return new ClaimsReimbursement(
//                dto.getId(),
//                dto.getEmployeeId(),
//                dto.getClaimType(),
//                dto.getClaimAmount(),
//                dto.getClaimDate(),
//                dto.getStatus(),
//                dto.getRemarks()
        );
    }
}
