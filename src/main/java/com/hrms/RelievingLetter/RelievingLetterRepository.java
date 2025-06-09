package com.hrms.RelievingLetter;


import com.hrms.RelievingLetter.RelievingLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelievingLetterRepository extends JpaRepository<RelievingLetter, Long> {
}
