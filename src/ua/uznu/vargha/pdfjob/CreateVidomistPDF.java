/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.uznu.vargha.pdfjob;

/**
 * @author Sabee
 */
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import ua.uznu.vargha.VidomistObj;
import static ua.uznu.vargha.pdfjob.CreatePDF.*;

/**
 *
 * @author 89502
 */
public class CreateVidomistPDF implements CreatePDF {

    public static String nazvaUstanovy = "Тисаашванська с/р";

    public static String DATE[] = new String[2];
    public static final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static PDFFile pdffile;
    private static PDFPage pagee;
    public static PDDocument doc;

    /**
     * Збереження документа в PDF файл
     *
     * @param f файл
     * @throws IOException
     */
    public static void saveToFile(File f) throws IOException {
        doc.save(f);
    }

    /**
     * Створення документа
     *
     * @return масив байтів
     */
    @Override
    public ByteBuffer create() {
        ByteBuffer buf;
        try {
            System.out.println("Creating ...");
            out.reset();
            doc = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);

            doc.addPage(page);

            PDPageContentStream content = new PDPageContentStream(doc, page, false, false);

            content.setFont(CreatePDF.setFontTimesNewRoman(doc), 11);
            addString("Найменування установи", 30, 810, content);
            addString(nazvaUstanovy, 30, 795, content);

            content.setFont(CreatePDF.setFontBoldTimesNewRoman(doc), 14);
            addStringToCenter("Відомість про нарахування заробітної плати", 760, page, content, setFontBoldTimesNewRoman(doc), 14);
            addStringToCenter("за " + DATE[0] + " місяць " + DATE[1] + " р. ", 745, page, content, setFontBoldTimesNewRoman(doc), 14);

            int interval = 700;
            content.setFont(CreatePDF.setFontBoldTimesNewRoman(doc), 11);

            content.drawLine(0, interval + 12, 595, interval + 12);
            addString("ПІБ", 20, interval, content);
            addString("Ідентифікаційний код", 110, interval, content);
            addString("Нарахування", 225, interval, content);
            addString("Податок", 300, interval, content);
            addString("Військовий збір", 350, interval, content);
            addString("Профспілка", 435, interval, content);
            addString("Утримано усього", 500, interval, content);
            content.drawLine(0, interval - 5, 595, interval - 5);
            content.setFont(CreatePDF.setFontTimesNewRoman(doc), 11);

            for (int i = 0; i < VidomistObj.nameList.size(); i++) {

                interval -= 15;

                addString(VidomistObj.nameList.get(i), 20, interval, content);
                addString(VidomistObj.idList.get(i).toString(), 110, interval, content);
                addString(VidomistObj.narahList.get(i).toString(), 225, interval, content);
                addString(VidomistObj.podatokList.get(i).toString(), 300, interval, content);
                addString(VidomistObj.vPodatokList.get(i).toString(), 350, interval, content);
                addString(VidomistObj.profSpList.get(i).toString(), 435, interval, content);
                addString(VidomistObj.vsohoList.get(i).toString(), 500, interval, content);
            }
            content.drawLine(0, interval - 5, 595, interval - 5);
            content.setFont(CreatePDF.setFontBoldTimesNewRoman(doc), 11);
            addString("Голова                (_______________/_______)                           МП         _____________", 20, 130, content);
            addString("Гол. бухгалтер  (_______________/_______)                           МП         _____________", 20, 80, content);
            content.close();

            doc.save(out);
            buf = ByteBuffer.wrap(out.toByteArray());

            //doc.close();
            System.out.println("Succesfull!");
            return buf;
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return null;
    }

}
