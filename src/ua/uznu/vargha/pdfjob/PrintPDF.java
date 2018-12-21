package ua.uznu.vargha.pdfjob;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

/**
 * @author Sabee Друк файла
 */
public class PrintPDF {

    private static PDDocument pdf;

    /**
     * Друк документа
     *
     * @param docPDF PDF документ
     */
    private static void print(PDDocument docPDF) {
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPageable(new PDFPageable(docPDF));
            job.setJobName("Accountant document");
            if (job.printDialog()) {
                job.print();
            }
        } catch (PrinterException | NullPointerException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Друк файла
     *
     * @param document документ byte масив
     */
    public static void pirntPDFBytes(byte[] document) {
        try {
            pdf = PDDocument.load(document);
            print(pdf);
            pdf.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Друк файла
     *
     * @param file файл
     */
    public static void printPDFFile(File file) {
        try {
            pdf = PDDocument.load(file);
            print(pdf);
            pdf.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
