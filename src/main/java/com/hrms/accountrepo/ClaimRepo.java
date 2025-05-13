package com.hrms.accountrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entity.Claim;


public interface ClaimRepo extends JpaRepository<Claim, Long> {
}
