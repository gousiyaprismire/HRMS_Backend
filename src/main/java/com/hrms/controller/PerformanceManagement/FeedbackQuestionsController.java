package com.hrms.controller.PerformanceManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.model.PerformanceManagement.FeedbackQuestions;
import com.hrms.service.PerformanceManagement.FeedbackQuestionsService;

@RestController
@RequestMapping("/api/feedback-questions")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackQuestionsController {

	  @Autowired
	    private FeedbackQuestionsService feedbackQuestionsService;

	    @GetMapping
	    public List<FeedbackQuestions> getAllFeedbackQuestions() {
	        return feedbackQuestionsService.getAllFeedbackQuestions();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<FeedbackQuestions> getFeedbackQuestionById(@PathVariable Long id) {
	        Optional<FeedbackQuestions> question = feedbackQuestionsService.getFeedbackQuestionById(id);
	        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<FeedbackQuestions> addFeedbackQuestion(@RequestBody FeedbackQuestions question) {
	        FeedbackQuestions savedQuestion = feedbackQuestionsService.addFeedbackQuestion(question);
	        
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedQuestion);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<FeedbackQuestions> updateFeedbackQuestion(@PathVariable Long id,
	            @RequestBody FeedbackQuestions updatedQuestion) {
	       try {
	           updatedQuestion.setId(id); 
	           FeedbackQuestions updated = feedbackQuestionsService.updateFeedbackQuestion(id, updatedQuestion);
	           return ResponseEntity.ok(updated);
	       } catch (RuntimeException e) {
	           return ResponseEntity.notFound().build();
	       }
	   }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteFeedbackQuestion(@PathVariable Long id) {
	        feedbackQuestionsService.deleteFeedbackQuestion(id);
	        return ResponseEntity.noContent().build();
	    }
}
