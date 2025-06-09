package com.hrms.RelievingLetter;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

@Service
public class RelievingLetterServiceImpl implements RelievingLetterService {

    @Autowired
    private RelievingLetterRepository letterRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public RelievingLetter saveLetter(RelievingLetter letter) {
        return letterRepository.save(letter);
    }
    
    

    @Override
    public void sendRelievingLetterEmail(RelievingLetter letter) {
        try {

            File pdfFile = generatePdf(letter);

           
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(letter.getEmail());
            helper.setSubject("Your Relieving Letter");
            helper.setText("Dear " + letter.getEmployeeName() + ",\nPlease find your relieving letter attached.\n\nRegards,\nHR Team");

            helper.addAttachment("Relieving_Letter.pdf", pdfFile);

            mailSender.send(message);

       
            pdfFile.delete();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send relieving letter email.");
        }
    }

    private File generatePdf(RelievingLetter letter) throws Exception {
        Document document = new Document();
        File file = File.createTempFile("Relieving_Letter", ".pdf");
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();

        Image logo = Image.getInstance("src/main/resources/static/logo.png");
        logo.scaleToFit(110, 60);
        logo.setAlignment(Image.ALIGN_LEFT);
        document.add(logo);

        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

        Chunk underlineTitle = new Chunk("Relieving Letter", boldFont);
        underlineTitle.setUnderline(0.1f, -2f);

        Paragraph title = new Paragraph(underlineTitle);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setLeading(14f);
        document.add(title);

        Paragraph date = new Paragraph("Date: " + java.time.LocalDate.now());
        date.setAlignment(Element.ALIGN_RIGHT);
        date.setLeading(14f);
        document.add(date);

        document.add(new Paragraph("\n")); 

        Paragraph companyHeader = new Paragraph("Prismire Software Solutions Pvt Ltd \n\n");
        companyHeader.setLeading(14f);
        document.add(companyHeader);
        
//        document.add(new Paragraph("\n")); 

        Paragraph companyAddress = new Paragraph("HQ-10 of 1004, 10th Floor, Jain Sadguru Capital Park, Madhapur,\r\n" +
                "Hyderabad, Telangana, India, 500081\r\n" +
                "info@prismire.com\r\n" +
                "www.Prismire.com\n\n");
        companyAddress.setLeading(14f);
        document.add(companyAddress);

        Paragraph toPara = new Paragraph("To,\n" + letter.getEmployeeName() +
                "\n" + letter.getAddress() + "\n\nSubject: Relieving Letter\n\n");
        toPara.setLeading(14f);
        document.add(toPara);

        Paragraph salutation = new Paragraph("Dear " + letter.getEmployeeName() + ",\n\n");
        salutation.setLeading(14f);
        document.add(salutation);

        Paragraph para1 = new Paragraph("This is to formally acknowledge your resignation from your position as " +
                letter.getDesignation() + " at Prismire Software Solutions Pvt Ltd, which was effective from " +
                letter.getJoiningDate() + " to " + letter.getRelievingDate() +
                ". We confirm that all formalities related to your resignation including the completion of your duties and the handover of projects, have been successfully completed.\n\n");
        para1.setLeading(14f);
        document.add(para1);

        Paragraph para2 = new Paragraph("As of " + letter.getRelievingDate() + ", you have been relieved of your duties, " +
                "and we consider your employment with Prismire Software Solutions Pvt Ltd officially terminated. Your full and final settlement has been processed as per the company's policies and guidelines.\n\n");
        para2.setLeading(14f);
        document.add(para2);

        Paragraph para3 = new Paragraph("We appreciate the dedication, hard work, and contributions you made during your tenure with us. Your role as a " + letter.getDesignation() +
                " was vital in ensuring the quality and reliability of the software products, and your efforts will be remembered.\n\n");
        para3.setLeading(14f);
        document.add(para3);

        Paragraph para4 = new Paragraph("We wish you the very best in your future endeavors and continued success in your professional career.\n\n");
        para4.setLeading(14f);
        document.add(para4);
        
        Paragraph para5 = new Paragraph("Thank you once again, and we hope your experience with us was fulfilling.\n\n");
        para4.setLeading(14f);
        document.add(para5);

        Paragraph closing = new Paragraph("Sincerely,\nHR Manager \nPrismire Software Solutions Pvt Ltd \n\n\n");
        closing.setLeading(14f);
        document.add(closing);

        Paragraph companyInfo = new Paragraph(
                "Prismire Software Solutions Pvt Ltd \n" +
                "10th Floor, Jain Sadhu Guru Image’s Capital Park, Madhapur, Hyderabad, Telangana-500081 \n" +
                "Website: https://www.prismire.com, Mail ID: hr.pdc@prismire.com, Mobile No: +91 7601077112",
                boldFont
        );
        companyInfo.setAlignment(Element.ALIGN_CENTER);
        companyInfo.setLeading(14f);
        document.add(companyInfo);

        document.close();
        return file;
    }


    @Override
    public Optional<RelievingLetter> findById(Long id) {
        return letterRepository.findById(id);
    }

    @Override
    public List<RelievingLetter> findAll() {
        return letterRepository.findAll();
    }
}
