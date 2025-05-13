package com.hrms.accountservice;

import com.hrms.entity.Claim;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface ClaimService {
	Claim createClaim(String employeeName, String claimType, double claimAmount, MultipartFile file, LocalDate claimDate) throws IOException;

    Claim getClaimById(Long id);
    List<Claim> getAllClaims();
}
