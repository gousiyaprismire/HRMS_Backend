package com.hrms.RelievingLetter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/api/relieving_letter")
@CrossOrigin(origins = "http://localhost:3000")
public class RelievingLetterController {

    @Autowired
    private RelievingLetterService relievingLetterService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateLetter(@RequestBody RelievingLetter letter) {
        try {
            ByteArrayOutputStream out = relievingLetterService.generateRelievingLetterPdf(letter);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=relieving_letter.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(out.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(("Failed to generate PDF: " + e.getMessage()).getBytes());
        }
    }


}
