package com.hrms.accountrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.Employ;

@Repository
public interface EmployRepo extends JpaRepository<Employ, Long> {
    
}
