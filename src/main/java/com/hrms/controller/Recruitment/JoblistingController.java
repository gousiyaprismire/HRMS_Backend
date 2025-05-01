package com.hrms.controller.Recruitment;


import com.hrms.model.Recruitment.Joblisting;
import com.hrms.service.Recruitment.JoblistingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:3000")
public class JoblistingController {

    @Autowired
    private JoblistingService service;

    @GetMapping
    public List<Joblisting> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Joblisting> getJobById(@PathVariable Long id) {
        Optional<Joblisting> job = service.getJobById(id);
        return job.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Joblisting createJob(@RequestBody Joblisting job) {
        return service.createJob(job);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Joblisting> updateJob(@PathVariable Long id, @RequestBody Joblisting job) {
        Joblisting updatedJob = service.updateJob(id, job);
        return updatedJob != null ? ResponseEntity.ok(updatedJob) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        service.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
}
 