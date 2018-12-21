package ua.uznu.vargha.pdfjob;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Sabee
 */
public class DisplayPDFPage {

    private static int pageCount;
    private static PDFFile pdffile;
    private static PDFPage page;
    private static int pgaeWidth;
    private static int pageHeight;

    /**
     * Повертає ширину сторінки
     *
     * @return ширину
     */
    public static int getPgaeWidth() {
        return pgaeWidth;
    }

    /**
     * Налаштування ширини сторінки
     *
     * @param pgaeWidth ширина
     */
    private static void setPgaeWidth(int pgaeWidth) {
        DisplayPDFPage.pgaeWidth = pgaeWidth;
    }

    /**
     * Повертає довжину сторінки
     *
     * @return довжину
     */
    public static int getPageHeight() {
        return pageHeight;
    }

    /**
     * Налаштування довжини сторінки
     *
     * @param pageHeight довжина
     */
    private static void setPageHeight(int pageHeight) {
        DisplayPDFPage.pageHeight = pageHeight;
    }

    /**
     * Повертає к-ть сторінок
     *
     * @return К-сть сторінок
     */
    public static int getPageCount() {
        return pageCount;
    }

    /**
     * Налаштування к-сті сторінок
     *
     * @param pageCount к-ть сторінок
     */
    private static void setPageCount(int pageCount) {
        DisplayPDFPage.pageCount = pageCount;
    }

    /**
     *
     * @param buf масив байтів
     * @param label для відображення картинки
     * @param pageID номер сторінки
     * @throws Exception
     */
    public static void showPage(ByteBuffer buf, JLabel label, int pageID) throws Exception {
        pdffile = new PDFFile(buf);
        setPageCount(pdffile.getNumPages());

        page = pdffile.getPage(pageID);

        setPgaeWidth((int) page.getWidth());
        setPageHeight((int) page.getHeight());

        Rectangle rect = new Rectangle(0, 0, (int) page.getBBox().getWidth(), (int) page.getBBox().getHeight());

        Image img = page.getImage(
                rect.width, rect.height,
                rect,
                null,
                true,
                true
        );
        buf.clear();
        label.setIcon(new ImageIcon(img));
    }

    /**
     * Завантаження документуа з файлів
     *
     * @param fileName імя файлу
     * @return масив байтів
     */
    public static ByteBuffer getPDFFromFile(String fileName) {
        File file;
        RandomAccessFile raf;
        FileChannel channel;
        ByteBuffer buf;
        try {
            file = new File(fileName);
            raf = new RandomAccessFile(file, "r");
            channel = raf.getChannel();
            buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            channel.close();
            raf.close();
            return buf;
        } catch (Exception e) {
            //System.err.println(e);
            return null;
        }
    }
}
