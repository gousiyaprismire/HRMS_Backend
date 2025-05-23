package com.hrms.repository.Selfservice;



import com.hrms.model.SelfService.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByEmployeeId(Long employeeId);
}

