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
import ua.uznu.vargha.OneDFObj;
import static ua.uznu.vargha.pdfjob.CreatePDF.*;

/**
 * @author Sabee
 */
public class CreateOneDFPDF implements CreatePDF {

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

            addStringToCenter("Податковий розрахунок", 770, page, content, setFontBoldTimesNewRoman(doc), 12);
            addStringToCenter("сум доходу, нарахованого (сплаченого) на користь фізичних осіб, і сум утриманого з них податку", 750, page, content, setFontBoldTimesNewRoman(doc), 12);
            addStringToCenter("Звітний періодм " + DATE[0] + " квартал " + DATE[1] + " рік", 735, page, content, setFontTimesNewRoman(doc), 12);
            int interval = 680;
            content.setFont(setFontBoldTimesNewRoman(doc), 11);

            content.drawLine(0, interval + 12, 595, interval + 12);

            addString("Податковий номер", 20, interval - 7, content);
            addString("Сума нарах. доходу", 120, interval - 7, content);
            addString("Сума виплач. доходу", 230, interval - 7, content);
            addString("Сума утриманого податку", 350, interval, content);
            addString("нарах.", 360, interval - 15, content);
            addString("перерах.", 430, interval - 15, content);
            addString("Ознака доходу", 500, interval - 7, content);

            content.drawLine(0, interval - 25, 595, interval - 25);
            content.setFont(setFontTimesNewRoman(doc), 11);
            interval = interval - 25;
            for (int i = 0; i < OneDFObj.idenList.size(); i++) {

                interval -= 15;

                addString(OneDFObj.idenList.get(i).toString(), 20, interval, content);
                addString(OneDFObj.sumhDohodList.get(i).toString(), 120, interval, content);
                addString(OneDFObj.sumhDohodList.get(i).toString(), 230, interval, content);
                addString(OneDFObj.sumUtrymane.get(i).toString(), 360, interval, content);
                addString(OneDFObj.sumUtrymane.get(i).toString(), 430, interval, content);
                addString(OneDFObj.oznakaList.get(i).toString(), 500, interval, content);
            }
            content.drawLine(0, interval - 5, 595, interval - 5);
            content.setFont(setFontBoldTimesNewRoman(doc), 11);
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
