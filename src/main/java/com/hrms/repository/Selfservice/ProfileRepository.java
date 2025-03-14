package com.hrms.repository.Selfservice;

import com.hrms.model.SelfService.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}

