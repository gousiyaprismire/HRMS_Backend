package com.hrms.repository.PerformanceManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.model.PerformanceManagement.AppraisalForm;

@Repository
public interface AppraisalFormRepository extends JpaRepository<AppraisalForm, Long>{

}
