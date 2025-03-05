package com.hrms.service.Recruitment;


import com.hrms.model.Recruitment.Joblisting;
import com.hrms.repository.Recruitment.JoblistingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoblistingService {

    @Autowired
    private JoblistingRepository repository;

    public List<Joblisting> getAllJobs() {
        return repository.findAll();
    }

    public Optional<Joblisting> getJobById(Long id) {
        return repository.findById(id);
    }

    public Joblisting createJob(Joblisting job) {
        return repository.save(job);
    }

    public Joblisting updateJob(Long id, Joblisting updatedJob) {
        return repository.findById(id).map(job -> {
            if (updatedJob.getTitle() != null) job.setTitle(updatedJob.getTitle());
            if (updatedJob.getDepartment() != null) job.setDepartment(updatedJob.getDepartment());
            if (updatedJob.getLocation() != null) job.setLocation(updatedJob.getLocation());
            if (updatedJob.getJobType() != null) job.setJobType(updatedJob.getJobType());
            if (updatedJob.getDescription() != null) job.setDescription(updatedJob.getDescription());
            if (updatedJob.getPostedDate() != null) job.setPostedDate(updatedJob.getPostedDate());
            if (updatedJob.getApplicationDeadline() != null) job.setApplicationDeadline(updatedJob.getApplicationDeadline());

            return repository.save(job);
        }).orElseThrow(() -> new RuntimeException("Job listing not found with id: " + id));
    }



    public void deleteJob(Long id) {
        repository.deleteById(id);
    }
}
