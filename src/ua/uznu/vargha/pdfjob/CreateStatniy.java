/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.uznu.vargha.pdfjob;

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
import ua.uznu.vargha.StatniyObj;
import static ua.uznu.vargha.pdfjob.CreatePDF.*;

/**
 * @author Sabee
 */
public class CreateStatniy {

    public static String nazvaUstanovy = "Тисаашванська с/р";
    public static String DATE = "";
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

            addStringToCenter("Типовий штатний розпис на " + DATE, 770, page, content, setFontBoldTimesNewRoman(doc), 14);
            addStringToCenter(nazvaUstanovy, 750, page, content, setFontTimesNewRoman(doc), 12);
            int interval = 680;
            content.setFont(setFontBoldTimesNewRoman(doc), 11);

            content.drawLine(0, interval + 12, 595, interval + 12);

            addString("Назва посад", 20, interval - 7, content);
            addString("Ставка", 125, interval - 7, content);
            addString("Посадовий оклад", 170, interval - 7, content);
            addString("Ранг", 270, interval - 7, content);
            addString("Ранг грн", 310, interval - 7, content);
            addString("Вислуга %", 380, interval - 7, content);
            addString("Вислуга грн", 450, interval - 7, content);
            addString("Фонд з.п.", 520, interval - 7, content);
            content.drawLine(0, interval - 25, 595, interval - 25);
            content.setFont(setFontTimesNewRoman(doc), 11);
            interval = interval - 25;
            for (int i = 0; i < StatniyObj.nazvPosadList.size(); i++) {

                interval -= 15;

                addString(StatniyObj.nazvPosadList.get(i).toString(), 20, interval, content);
                addString(StatniyObj.okladList.get(i).toString(), 130, interval, content);
                addString(StatniyObj.posOkladList.get(i).toString(), 170, interval, content);
                addString(StatniyObj.rangList.get(i).toString(), 270, interval, content);
                addString(StatniyObj.rangHRNLIst.get(i).toString(), 310, interval, content);
                addString(StatniyObj.visluhaList.get(i).toString(), 380, interval, content);
                addString(StatniyObj.vislHRNLIst.get(i).toString(), 450, interval, content);
                addString(StatniyObj.fondZPList.get(i).toString(), 520, interval, content);
            }
            content.drawLine(0, interval - 5, 595, interval - 5);
            content.setFont(setFontBoldTimesNewRoman(doc), 11);
            interval -= 20;
            addString("Всього", 20, interval, content);
            addString("" + StatniyObj.getVsoho(StatniyObj.okladList), 130, interval, content);
            addString("" + StatniyObj.getVsoho(StatniyObj.posOkladList), 170, interval, content);
            addString("" + StatniyObj.getVsoho(StatniyObj.rangHRNLIst), 310, interval, content);
            addString("" + StatniyObj.getVsoho(StatniyObj.vislHRNLIst), 450, interval, content);
            addString("" + StatniyObj.getVsoho(StatniyObj.fondZPList), 520, interval, content);
            interval = interval - 5;
            content.drawLine(0, interval - 5, 595, interval - 5);
            //content.setFont(setFontBoldTimesNewRoman(doc), 11);
            addString("Голова                (_______________/_______)                           МП         _____________", 30, 130, content);
            addString("Гол. бухгалтер  (_______________/_______)                           МП         _____________", 30, 80, content);
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
