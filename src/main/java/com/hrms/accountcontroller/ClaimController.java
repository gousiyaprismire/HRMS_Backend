package com.hrms.accountcontroller;

import com.hrms.accountrepo.ClaimRepo;
import com.hrms.entity.Claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimRepo claimRepository;

    @PostMapping("/create")
    public ResponseEntity<Claim> createClaim(
            @RequestParam("employeeName") String employeeName,
            @RequestParam("claimType") String claimType,
            @RequestParam("claimAmount") double claimAmount,
            @RequestParam("claimDate") String claimDate,
            @RequestParam(value = "file", required = false) MultipartFile file) {

        
        LocalDate parsedClaimDate = LocalDate.parse(claimDate);

        
        Claim claim = new Claim();
        claim.setEmployeeName(employeeName);
        claim.setClaimType(claimType);
        claim.setClaimAmount(claimAmount);
        claim.setClaimDate(parsedClaimDate);

        // Handle file upload (store image as BLOB)
        if (file != null && !file.isEmpty()) {
            try {
                byte[] fileBytes = file.getBytes();  // Convert file to byte array
                claim.setFileData(fileBytes);        // Set the byte data as BLOB
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }

        // Save the claim to the database
        Claim savedClaim = claimRepository.save(claim);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClaim);
    }

    @GetMapping("/{claimId}/file")
    public ResponseEntity<byte[]> getFile(@PathVariable Long claimId) {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        byte[] fileData = claim.getFileData();

        if (fileData == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok()
                .header("Content-Type", "image/jpeg")  // Add the content type based on the image type
                .body(fileData);  // Return the file data as the response body
    }

    @GetMapping
    public ResponseEntity<Iterable<Claim>> getAllClaims() {
        Iterable<Claim> claims = claimRepository.findAll();
        return ResponseEntity.ok().body(claims);
    }
}
