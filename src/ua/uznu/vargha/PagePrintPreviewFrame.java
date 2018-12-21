package ua.uznu.vargha;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import ua.uznu.vargha.pdfjob.DisplayPDFPage;
import java.nio.ByteBuffer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import ua.uznu.vargha.pdfjob.CreateOneDFPDF;
import ua.uznu.vargha.pdfjob.CreateStatniy;
import ua.uznu.vargha.pdfjob.CreateVidomistPDF;
import ua.uznu.vargha.pdfjob.PrintPDF;

/**
 *
 * @author 89502
 */
public class PagePrintPreviewFrame extends javax.swing.JFrame {

    private static PagePrintPreviewFrame obj = null;
    public static File printFile = null;
    private static JLabel menuLabel;
    private final JMenu menuNext = new JMenu();
    private static int pageCount;
    private static int pageCurrent;
    private static ByteBuffer bbuf = ByteBuffer.allocate(1000);
    public static int SAVESELECTOR = 0;

    /**
     * Creates new form PagePrintPreviewFrame
     */
    private PagePrintPreviewFrame(ByteBuffer buf) {
        initComponents();

        super.setIconImage(new ImageIcon(getClass().getResource("/ua/uznu/vargha/abacus.png")).getImage());

        super.setMinimumSize(super.getSize());
        super.setResizable(false);
        addMenuComponents();

        load(buf);
    }

    public static PagePrintPreviewFrame getInstance(ByteBuffer buf) {
        if (obj == null) {
            obj = new PagePrintPreviewFrame(buf);
        } else {
            load(buf);
        }
        return obj;
    }

    /**
     * Завантаження сторинки
     *
     * @param buf байт масив
     */
    private static void load(ByteBuffer buf) {
        //bbuf.clear();
        bbuf = buf;
        pageCurrent = 1;
        showPage(pageCurrent);
        pageCount = DisplayPDFPage.getPageCount();
        menuLabel.setText(pageCurrent + "/" + pageCount);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PageScrollContainer = new javax.swing.JScrollPane();
        PageContainer = new javax.swing.JPanel();
        PageIMG = new javax.swing.JLabel();
        MainMenu = new javax.swing.JMenuBar();
        menuSave = new javax.swing.JMenu();
        menuPrint = new javax.swing.JMenu();
        menuPrev = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 800));
        setMinimumSize(new java.awt.Dimension(1024, 430));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        PageScrollContainer.setBackground(new java.awt.Color(153, 153, 153));
        PageScrollContainer.setBorder(null);

        PageContainer.setBackground(new java.awt.Color(153, 153, 153));
        PageContainer.add(PageIMG);

        PageScrollContainer.setViewportView(PageContainer);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 959;
        gridBagConstraints.ipady = 408;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(PageScrollContainer, gridBagConstraints);

        MainMenu.setBackground(new java.awt.Color(204, 204, 204));

        menuSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/save.png"))); // NOI18N
        menuSave.setToolTipText("Зберегти в .pdf файл");
        menuSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSaveMouseClicked(evt);
            }
        });
        MainMenu.add(menuSave);

        menuPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/printer.png"))); // NOI18N
        menuPrint.setToolTipText("Друк");
        menuPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPrintMouseClicked(evt);
            }
        });
        MainMenu.add(menuPrint);

        menuPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/left-arrow.png"))); // NOI18N
        menuPrev.setToolTipText("Попередній ");
        menuPrev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPrevMouseClicked(evt);
            }
        });
        MainMenu.add(menuPrev);

        setJMenuBar(MainMenu);

        setSize(new java.awt.Dimension(993, 486));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPrintMouseClicked
        if (printFile != null) {
            PrintPDF.printPDFFile(printFile);
            printFile = null;
        } else {
            PrintPDF.pirntPDFBytes(bbuf.array());
        }
    }//GEN-LAST:event_menuPrintMouseClicked

    private void menuPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPrevMouseClicked
        if (pageCurrent > 1) {
            pageCurrent--;
            menuLabel.setText(pageCurrent + "/" + pageCount);
            showPage(pageCurrent);
        } else {
            pageCurrent = pageCount;
            menuLabel.setText(pageCurrent + "/" + pageCount);
            showPage(pageCurrent);
        }
    }//GEN-LAST:event_menuPrevMouseClicked

    private void menuSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSaveMouseClicked
        savePDFToFile();
    }//GEN-LAST:event_menuSaveMouseClicked
    private void menuNextMouseClicked(java.awt.event.MouseEvent evt) {
        if (pageCurrent < pageCount) {
            pageCurrent++;
            menuLabel.setText(pageCurrent + "/" + pageCount);
            showPage(pageCurrent);
        } else {
            pageCurrent = 1;
            menuLabel.setText(pageCurrent + "/" + pageCount);
            showPage(pageCurrent);
        }
    }

    /**
     * Відображення сторинки
     *
     * @param pageNum номер сторинки
     */
    private static void showPage(int pageNum) {
        try {
            DisplayPDFPage.showPage(bbuf, PageIMG, pageNum);
        } catch (Exception e) {
            Desktop dt = Desktop.getDesktop();
            try {
                File f = File.createTempFile("tmp", ".pdf");
                FileOutputStream fos = new FileOutputStream(f);
                fos.write(bbuf.array());
                fos.close();
                dt.open(new File(f.getAbsolutePath()));
                //Process p =
                //Runtime.getRuntime()
                //.exec("rundll32 url.dll,FileProtocolHandler " + f.getAbsolutePath());
                //} catch (IOException ex) {
                //Logger.getLogger(ReadExcelUI.class.getName()).log(Level.SEVERE, null, ex);
                //} 
                f.deleteOnExit();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Файл не підтримується або пошкоджений!", "Помилка", JOptionPane.ERROR_MESSAGE);
                System.err.println(e);

            }
            System.err.println(e);
        }
    }

    /**
     * Додає до меню пункт меню
     */
    private void addMenuComponents() {
        menuLabel = new JLabel("1/" + pageCount);
        menuLabel.setToolTipText("Кількість сторінок");
        MainMenu.add(menuLabel);
        menuNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/right-arrow.png")));
        menuNext.setToolTipText("Hаступний");
        menuNext.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuNextMouseClicked(evt);
            }
        });
        menuNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MainMenu.add(menuNext);

    }

    /**
     * Збереження файла
     *
     * @param file файл
     * @throws IOException
     */
    private void selectSave(File file) throws IOException {
        switch (SAVESELECTOR) {
            case 1:
                CreateVidomistPDF.saveToFile(file);
                break;
            case 2:
                CreateOneDFPDF.saveToFile(file);
                break;
            case 3:
                CreateStatniy.saveToFile(file);
                break;
            default:
                System.err.println("Save selection null");
                break;
        }
    }

    /**
     * Вибір місця збереження
     */
    private void savePDFToFile() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PDF files", "pdf");
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setDialogTitle("Зберегти");
        int returnVal = chooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = chooser.getSelectedFile();
                file = new File(file.toString() + ".pdf");
                selectSave(file);
            } catch (IOException ex) {
                System.err.println(ex);
            }
        } else {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuBar MainMenu;
    private javax.swing.JPanel PageContainer;
    private static javax.swing.JLabel PageIMG;
    private javax.swing.JScrollPane PageScrollContainer;
    private javax.swing.JMenu menuPrev;
    private javax.swing.JMenu menuPrint;
    public static javax.swing.JMenu menuSave;
    // End of variables declaration//GEN-END:variables
}
