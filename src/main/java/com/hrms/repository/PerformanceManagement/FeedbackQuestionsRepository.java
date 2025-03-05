package com.hrms.repository.PerformanceManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.model.PerformanceManagement.FeedbackQuestions;

@Repository
public interface FeedbackQuestionsRepository extends JpaRepository<FeedbackQuestions, Long> {

}
