package com.hrms.repository.Recruitment;



import com.hrms.model.Recruitment.Joblisting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoblistingRepository extends JpaRepository<Joblisting, Long> {
}
