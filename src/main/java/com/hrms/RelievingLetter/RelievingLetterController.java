package com.hrms.RelievingLetter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/letters")
@CrossOrigin(origins = "http://localhost:3000")
public class RelievingLetterController {

    @Autowired
    private RelievingLetterService letterService;

    @PostMapping("/save")
    public ResponseEntity<RelievingLetter> saveLetter(@RequestBody RelievingLetter letter) {
        RelievingLetter savedLetter = letterService.saveLetter(letter);
        return ResponseEntity.ok(savedLetter);
    }

    @PostMapping("/generate")
    public ResponseEntity<RelievingLetter> generateLetter(@RequestBody RelievingLetter letter) {
        System.out.println("Received address: " + letter.getAddress()); // Debug log
        return ResponseEntity.ok(letterService.saveLetter(letter));
    }

    @PostMapping("/send-mail/{id}")
    public ResponseEntity<String> sendMail(@PathVariable Long id) {
        Optional<RelievingLetter> optionalLetter = letterService.findById(id);
        if (optionalLetter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        RelievingLetter letter = optionalLetter.get();
        letterService.sendRelievingLetterEmail(letter);
        return ResponseEntity.ok("Email sent successfully");
    }

    @GetMapping
    public ResponseEntity<java.util.List<RelievingLetter>> getAllLetters() {
        java.util.List<RelievingLetter> letters = letterService.findAll();
        return ResponseEntity.ok(letters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelievingLetter> getLetterById(@PathVariable Long id) {
        Optional<RelievingLetter> optionalLetter = letterService.findById(id);
        return optionalLetter
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<RelievingLetter> updateLetter(@PathVariable Long id, @RequestBody RelievingLetter updatedLetter) {
        Optional<RelievingLetter> optionalLetter = letterService.findById(id);
        if (optionalLetter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        RelievingLetter existingLetter = optionalLetter.get();

        
        existingLetter.setEmployeeName(updatedLetter.getEmployeeName());
        existingLetter.setDesignation(updatedLetter.getDesignation());
        existingLetter.setJoiningDate(updatedLetter.getJoiningDate());
        existingLetter.setRelievingDate(updatedLetter.getRelievingDate());
        existingLetter.setEmail(updatedLetter.getEmail());
        existingLetter.setAddress(updatedLetter.getAddress());

        RelievingLetter savedLetter = letterService.saveLetter(existingLetter);
        return ResponseEntity.ok(savedLetter);
    }

}
