package com.practice.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

@RestController
@RequestMapping("/v1/pdf")
public class PDFController {

    @GetMapping("/")
    public ResponseEntity<?> generatePdf() throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("SampleHelloWorld.pdf"));

        document.open();
        for(String line: data())
            document.add(new Paragraph(line));
        document.close();

        return ResponseEntity.ok("SUCESS");
    }

    private java.util.List<String> data() {

        java.util.List<String> data = new ArrayList<>();
        data.add("yrtyrt, fdhfghfg, 7686786, 879879, 768687");
        data.add("yrtyrt, fdhfghfg, 7686786, 879879, 768687");
        data.add("yrtyrt, fdhfghfg, 7686786, 879879, 768687");
        data.add("yrtyrt, fdhfghfg, 7686786, 879879, 768687");
        data.add("yrtyrt, fdhfghfg, 7686786, 879879, 768687");
        data.add("yrtyrt, fdhfghfg, 7686786, 879879, 768687");
        data.add("yrtyrt, fdhfghfg, 7686786, 879879, 768687");
        data.add("yrtyrt, fdhfghfg, 7686786, 879879, 768687");

        return data;
    }
}
