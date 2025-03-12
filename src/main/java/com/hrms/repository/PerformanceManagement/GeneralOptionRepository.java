package com.hrms.repository.PerformanceManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.model.PerformanceManagement.GeneralOption;

@Repository
public interface GeneralOptionRepository extends JpaRepository <GeneralOption, Long>{

}