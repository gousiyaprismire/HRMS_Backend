package com.hrms.service.Recruitment;

import com.hrms.model.Recruitment.Interview;
import com.hrms.repository.Recruitment.InterviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;

    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    public Interview scheduleInterview(Interview interview) {
        interview.setStatus("Scheduled");
        return interviewRepository.save(interview);
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public Interview getInterviewById(Long id) {
        return interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found with id: " + id));
    }

    public Interview rescheduleInterview(Long id, LocalDateTime newTime) {
        Interview interview = interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found with id: " + id));

        interview.setScheduledTime(newTime);
        interview.setStatus("Rescheduled");
        return interviewRepository.save(interview);
    }

    public void cancelInterview(Long id) {
        if (!interviewRepository.existsById(id)) {
            throw new RuntimeException("Interview not found with id: " + id);
        }
        interviewRepository.deleteById(id);
    }
}
