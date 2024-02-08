package com.practice.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class PDFService {

    public void generateRequiredPdf() throws FileNotFoundException, DocumentException {

        List<Header> headersList = getHeaders();
        generatePdf("TransSchedule.pdf", headersList, getTrainData());
    }


    private void generatePdf(String pdfName, List<Header> headersList, List<TrainData> trainData) throws FileNotFoundException, DocumentException {

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(pdfName));

        document.open();

        PdfPTable table = new PdfPTable(12);
        table.setTotalWidth(100);
        table.setWidths(new int[]{5,5,5,5,5,5,5,5,5,15,15,15});
        addTableHeader(table, headersList);
        addRows(table, trainData);

        document.add(table);
        document.close();
    }

    private void addRows(PdfPTable table, List<TrainData> trainData) {

        table.addCell(addCell(trainData.get(0).getTrain()));
        table.addCell(addCell(trainData.get(0).getDay()));
        table.addCell(addCell(trainData.get(0).getUnits()));
        table.addCell(addCell(trainData.get(0).getStatus()));
        table.addCell(addCell(trainData.get(0).getDelay()));
        table.addCell(addCell(trainData.get(0).getEstTrainArrival()));
        table.addCell(addCell(trainData.get(0).getEvent()));
        table.addCell(addCell(trainData.get(0).getDateAndTime()));
        table.addCell(addCell(trainData.get(0).getLocation()));
        table.addCell(addCell(trainData.get(0).getOriginTrain()));
        table.addCell(addCell(trainData.get(0).getDestinationTrain()));
        table.addCell(addCell(trainData.get(0).getFinalDestination()));

        table.addCell(addCell(trainData.get(1).getTrain()));
        table.addCell(addCell(trainData.get(1).getDay()));
        table.addCell(addCell(trainData.get(1).getUnits()));
        table.addCell(addCell(trainData.get(1).getStatus()));
        table.addCell(addCell(trainData.get(1).getDelay()));
        table.addCell(addCell(trainData.get(1).getEstTrainArrival()));
        table.addCell(addCell(trainData.get(1).getEvent()));
        table.addCell(addCell(trainData.get(1).getDateAndTime()));
        table.addCell(addCell(trainData.get(1).getLocation()));
        table.addCell(addCell(trainData.get(1).getOriginTrain()));
        table.addCell(addCell(trainData.get(1).getDestinationTrain()));
        table.addCell(addCell(trainData.get(1).getFinalDestination()));
    }

    private void addTableHeader(PdfPTable table, List<Header> headersList) {

        headersList.forEach(entry -> {
            PdfPCell header = addCell(entry.getHeaderName());
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(entry.getWidth());
            table.addCell(header);
        });
    }

    private List<TrainData> getTrainData() {

        List<TrainData> trainData = new ArrayList<>();

        TrainData trainData1 = new TrainData();
        trainData1.setTrain("20X");
        trainData1.setDay("6");
        trainData1.setUnits("4");
        trainData1.setStatus("On Time");
        trainData1.setDelay("");
        trainData1.setEstTrainArrival("08-Feb 01:19");
        trainData1.setEvent("DFLC");
        trainData1.setDateAndTime("02/07/24 09:49");
        trainData1.setLocation("CONWAY SEWICKLEY SC,PA");
        trainData1.setOriginTrain("CHICAGO 47TH ST TV");
        trainData1.setDestinationTrain("MORRISVILLE TV");
        trainData1.setFinalDestination("PITTSBURGH");

        TrainData trainData2 = new TrainData();
        trainData2.setTrain("22M");
        trainData2.setDay("6");
        trainData2.setUnits("4");
        trainData2.setStatus("On Time");
        trainData2.setDelay("");
        trainData2.setEstTrainArrival("08-Feb 01:19");
        trainData2.setEvent("DFLC");
        trainData2.setDateAndTime("02/07/24 09:49");
        trainData2.setLocation("CONWAY SEWICKLEY SC,PA");
        trainData2.setOriginTrain("CHICAGO 47TH ST TV");
        trainData2.setDestinationTrain("MORRISVILLE TV");
        trainData2.setFinalDestination("PITTSBURGH");

        trainData.add(trainData1);
        trainData.add(trainData2);

        return trainData;
    }

    private List<Header> getHeaders() {

        List<Header> headers = new ArrayList<>();

        headers.add(new Header("TRAIN", 2));
        headers.add(new Header("DAY", 2));
        headers.add(new Header("UNITS", 2));
        headers.add(new Header("STATUS", 3));
        headers.add(new Header("DELAY", 2));
        headers.add(new Header("EST TRAIN ARRIVAL", 6));
        headers.add(new Header("EVENT", 2));
        headers.add(new Header("DATE/TIME", 5));
        headers.add(new Header("LOCATION", 4));
        headers.add(new Header("TRAIN ORIGIN", 8));
        headers.add(new Header("TRAIN DESTINATION", 8));
        headers.add(new Header("UNIT DESTINATION", 8));

        return headers;
    }

    private PdfPCell addCell(String text) {

        Font font = new Font(Font.FontFamily.COURIER, 8);
        PdfPCell cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPhrase(new Phrase(text, font));
        return cell;
    }
}
