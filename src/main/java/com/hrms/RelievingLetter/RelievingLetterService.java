package com.hrms.RelievingLetter;

import java.util.List;  // Correct import
import java.util.Optional;

public interface RelievingLetterService {
    RelievingLetter saveLetter(RelievingLetter letter);
    void sendRelievingLetterEmail(RelievingLetter letter);
    Optional<RelievingLetter> findById(Long id);
    List<RelievingLetter> findAll();
}
