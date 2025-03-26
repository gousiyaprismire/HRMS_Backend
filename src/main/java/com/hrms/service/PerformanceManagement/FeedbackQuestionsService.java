package com.hrms.service.PerformanceManagement;

import com.hrms.model.PerformanceManagement.FeedbackQuestions;
import java.util.List;
import java.util.Optional;

public interface FeedbackQuestionsService {
	
    List<FeedbackQuestions> getAllFeedbackQuestions();
    Optional<FeedbackQuestions> getFeedbackQuestionById(Long id);
    FeedbackQuestions addFeedbackQuestion(FeedbackQuestions question);
    FeedbackQuestions updateFeedbackQuestion(Long id, FeedbackQuestions updatedQuestion);
    void deleteFeedbackQuestion(Long id);
    
}
