/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.uznu.vargha.pdfjob;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

/**
 *
 * @author 89502
 */
public interface CreatePDF {

    /**
     * Завантаження шрифта
     *
     * @param doc документ
     * @return шрифт
     * @throws IOException
     */
    static PDType0Font setFontTimesNewRoman(PDDocument doc) throws IOException {
        PDType0Font font = PDType0Font.load(doc, new File("TNR.ttf"));
        return font;
    }

    /**
     * Завантаження шрифта
     *
     * @param doc документ
     * @return шрифт
     * @throws IOException
     */
    static PDType0Font setFontBoldTimesNewRoman(PDDocument doc) throws IOException {
        PDType0Font fontBold = PDType0Font.load(doc, new File("TNRB.ttf"));
        return fontBold;
    }

    public abstract ByteBuffer create();

    /**
     * Додавання текста в документ
     *
     * @param str текст
     * @param x координат х
     * @param y координат у
     * @param content документ
     * @throws Exception
     */
    static void addString(String str, float x, float y, PDPageContentStream content) throws Exception {
        content.beginText();
        content.moveTextPositionByAmount(x, y);
        content.drawString(str);
        content.endText();
    }

    /**
     * Додавання текста в документ
     *
     * @param str текст
     * @param x координат х
     * @param y координат у
     * @param content документ
     * @param font шрифт
     * @param fontSize розмір шрифта
     * @throws Exception
     */
    static void addString(String str, float x, float y, PDPageContentStream content, PDType0Font font, int fontSize) throws Exception {
        content.beginText();
        content.setFont(font, fontSize);
        content.moveTextPositionByAmount(x, y);
        content.drawString(str);
        content.endText();
    }

    /**
     * Додавання текста в документ по центру
     *
     * @param str текст
     * @param x координат х
     * @param page сторінка
     * @param content документ
     * @param font шрифт
     * @param fontSize розмір шрифта
     * @throws Exception
     */
    static void addStringToCenter(String str, float x, PDPage page, PDPageContentStream content, PDType0Font font, int fontSize) throws Exception {
        float titleWidth = font.getStringWidth(str) / 1000 * fontSize;
        float titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
        content.beginText();
        content.setFont(font, fontSize);
        content.moveTextPositionByAmount((page.getMediaBox().getWidth() - titleWidth) / 2,/* page.getMediaBox().getHeight() -*/ x - titleHeight);
        content.drawString(str);
        content.endText();
    }

}
