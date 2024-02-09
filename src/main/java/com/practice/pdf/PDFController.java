package com.practice.pdf;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/pdf")
public class PDFController {

    @Autowired
    private PDFService pdfService;

    @GetMapping("/")
    public ResponseEntity<?> generatePdf() throws IOException, DocumentException {

        pdfService.generateRequiredPdf();

        return ResponseEntity.ok("SUCESS");
    }
}
