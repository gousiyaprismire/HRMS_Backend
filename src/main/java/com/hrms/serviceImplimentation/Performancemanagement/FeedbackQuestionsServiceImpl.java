package com.hrms.serviceImplimentation.Performancemanagement;
import com.hrms.model.PerformanceManagement.FeedbackQuestions;
import com.hrms.repository.PerformanceManagement.FeedbackQuestionsRepository;
import com.hrms.service.PerformanceManagement.FeedbackQuestionsService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackQuestionsServiceImpl implements FeedbackQuestionsService {

    @Autowired
    private FeedbackQuestionsRepository feedbackQuestionsRepository;

    @Override
    public List<FeedbackQuestions> getAllFeedbackQuestions() {
        return feedbackQuestionsRepository.findAll();
    }

    @Override
    public Optional<FeedbackQuestions> getFeedbackQuestionById(Long id) {
        return feedbackQuestionsRepository.findById(id);
    }

    @Override
    @Transactional
    public FeedbackQuestions addFeedbackQuestion(FeedbackQuestions question) {
    	System.out.println("Inside addFeedbackQuestionService");
        return feedbackQuestionsRepository.save(question);
    }

    @Override
    public FeedbackQuestions updateFeedbackQuestion(Long id, FeedbackQuestions updatedQuestion) {
        return feedbackQuestionsRepository.findById(id).map(question -> {
            question.setQuestion(updatedQuestion.getQuestion());
            return feedbackQuestionsRepository.save(question);
        }).orElseThrow(() -> new RuntimeException("Feedback Question not found"));
    }

    @Override
    public void deleteFeedbackQuestion(Long id) {
        feedbackQuestionsRepository.deleteById(id);
    }
}

