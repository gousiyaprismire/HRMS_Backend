package com.hrms.controller.Recruitment;

import com.hrms.model.Recruitment.Interview;
import com.hrms.service.Recruitment.InterviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/interviews")
@CrossOrigin(origins = "http://localhost:3000")
public class InterviewController {

    private static final Logger logger = LoggerFactory.getLogger(InterviewController.class);
    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
        logger.info("InterviewController Loaded!");
    }

    @GetMapping
    public ResponseEntity<List<Interview>> getAllInterviews() {
        return ResponseEntity.ok(interviewService.getAllInterviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInterviewById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(interviewService.getInterviewById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interview not found");
        }
    }

    @PostMapping
    public ResponseEntity<?> scheduleInterview(@RequestBody Interview interview) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(interviewService.scheduleInterview(interview));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to schedule interview");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInterviewStatus(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        Optional<Interview> interviewOptional = interviewService.getInterviewByIdOptional(id); // Updated

        if (interviewOptional.isPresent()) {
            Interview interview = interviewOptional.get();
            String newStatus = updates.get("status");

            interview.setStatus(newStatus);
            interviewService.saveInterview(interview);

            return ResponseEntity.ok(interview);
        } else {
            return ResponseEntity.status(404).body("Interview not found");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelInterview(@PathVariable Long id) {
        try {
            interviewService.cancelInterview(id);
            return ResponseEntity.ok("Interview cancelled successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interview not found");
        }
    }
}
