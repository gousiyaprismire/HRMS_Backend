package com.hrms.accountservice;

import com.hrms.accountrepo.ClaimRepo;
import com.hrms.entity.Claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepo claimRepository;
    
    @Override
    public Claim createClaim(String employeeName, String claimType, double claimAmount, MultipartFile file, LocalDate claimDate) throws IOException {
        Claim claim = new Claim();
        claim.setEmployeeName(employeeName);
        claim.setClaimType(claimType);
        claim.setClaimAmount(claimAmount);
        claim.setClaimDate(claimDate != null ? claimDate : LocalDate.now());

        if (file != null && !file.isEmpty()) {
            claim.setFileName(file.getOriginalFilename());
            claim.setFileType(file.getContentType());
            claim.setFileData(file.getBytes());
        }

        return claimRepository.save(claim);
    }

    @Override
    public Claim getClaimById(Long id) {
        return claimRepository.findById(id).orElse(null);
    }

    @Override
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }
}
