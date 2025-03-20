package com.hrms.service.Recruitment;

import com.hrms.model.Recruitment.Interview;
import com.hrms.repository.Recruitment.InterviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;

    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    // ✅ Add this method to fetch an interview by ID
    public Interview getInterviewById(Long id) {
        return interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));
    }

    // ✅ Alternative method that returns Optional
    public Optional<Interview> getInterviewByIdOptional(Long id) {
        return interviewRepository.findById(id);
    }

    public Interview scheduleInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public Interview saveInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public void cancelInterview(Long id) {
        interviewRepository.deleteById(id);
    }
}
