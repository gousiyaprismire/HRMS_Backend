package com.hrms.repository.Recruitment;




import com.hrms.model.Recruitment.OfferLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferLetterRepository extends JpaRepository<OfferLetter, Long> {
}
