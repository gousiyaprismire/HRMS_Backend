package com.hrms.RelievingLetter;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

@Service
public class RelievingLetterServiceImpl implements RelievingLetterService {

    @Override
    public ByteArrayOutputStream generateRelievingLetterPdf(RelievingLetter letter) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        InputStream templateStream = getClass().getClassLoader().getResourceAsStream("templates/Relieving_Letter.pdf");
        if (templateStream == null) {
            throw new FileNotFoundException("Template PDF not found in resources/templates/");
        }

        PdfReader reader = new PdfReader(templateStream);
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdfDoc = new PdfDocument(reader, writer);

        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
        Map<String, PdfFormField> fields = form.getFormFields();

        fields.get("employeeName").setValue(letter.getEmployeeName());
        fields.get("designation").setValue(letter.getDesignation());
        fields.get("joiningDate").setValue(letter.getJoiningDate());
        fields.get("relievingDate").setValue(letter.getRelievingDate());

        form.flattenFields(); 

        pdfDoc.close();
        return out;
    }
}
