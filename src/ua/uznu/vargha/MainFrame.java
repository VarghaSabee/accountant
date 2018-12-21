package ua.uznu.vargha;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import ua.uznu.vargha.pdfjob.DisplayPDFPage;

/**
 * @author 89502
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        super.setIconImage(new ImageIcon(getClass().getResource("/ua/uznu/vargha/abacus.png")).getImage());

        setJTreeModel();
        setRendererJTree();
        addMouseListenerToJTree();

    }

    /**
     * Налаштування моделі таблиці
     */
    public static void setJTreeModel() {
        blankiTree.setModel(getJTreeModel());
    }

    /**
     * Відкриття файла
     *
     * @param str шлях до файлу
     */
    private void openFile(String str) {
        Desktop dt = Desktop.getDesktop();
        ByteFile bt = ConnectDB.selectFromDB(str);
        try {
            File f = File.createTempFile("tmp", bt.getExtension());
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(bt.getByteArr());
            fos.close();
            dt.open(new File(f.getAbsolutePath()));
            //Process p =
            //Runtime.getRuntime()
            //.exec("rundll32 url.dll,FileProtocolHandler " + f.getAbsolutePath());
            //} catch (IOException ex) {
            //Logger.getLogger(ReadExcelUI.class.getName()).log(Level.SEVERE, null, ex);
            //} 
            f.deleteOnExit();
        } catch (IOException e) {
            System.err.println(e);

        }
    }

    private void addMouseListenerToJTree() {
        blankiTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) blankiTree.getLastSelectedPathComponent();
                    if (node == null) {
                        return;
                    }
                    String str = node.getUserObject().toString();
                    switch (str) {
                        case "Бланки":
                            break;
                        case "Річна звітність":
                            break;
                        case "Квартална звітність":
                            break;
                        case "Місячна звітність":
                            break;
                        default:
                            openFile(str);
                    }
                }
            }
        });
    }

    /**
     * Формат іконки дереви
     */
    private void setRendererJTree() {
        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/document.png"));
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setLeafIcon(imageIcon);
        blankiTree.setCellRenderer(renderer);
    }

    private static DefaultMutableTreeNode getNames(List<String> list, String title) {
        DefaultMutableTreeNode dmtn = new DefaultMutableTreeNode(title);
        for (int i = 0; i < list.size(); i++) {
            dmtn.add(new DefaultMutableTreeNode(list.get(i), false));
        }
        return dmtn;
    }

    /**
     * Модель дереви
     *
     * @return модель дереви
     */
    private static DefaultTreeModel getJTreeModel() {
        try {
            ConnectDB.selectNamesFromDB();
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Бланки");
            DefaultMutableTreeNode richna = getNames(ConnectDB.rik, "Річна звітність");
            DefaultMutableTreeNode kvartalna = getNames(ConnectDB.kvartal, "Квартална звітність");
            DefaultMutableTreeNode misyachna = getNames(ConnectDB.misyac, "Місячна звітність");

            root.add(misyachna);
            root.add(kvartalna);
            root.add(richna);

            DefaultTreeModel model = new DefaultTreeModel(root, true);
            return model;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Не вдалося завантажити базу даних", "Помилка", JOptionPane.ERROR_MESSAGE);
            formMenu.setEnabled(false);
            statniyBtn.setEnabled(false);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statniyBtn = new javax.swing.JButton();
        blankiContainer = new javax.swing.JScrollPane();
        blankiTree = new javax.swing.JTree();
        titleLbl = new javax.swing.JLabel();
        vidomistBtn = new javax.swing.JButton();
        oneDFBtn = new javax.swing.JButton();
        mainMenu = new javax.swing.JMenuBar();
        openMenu = new javax.swing.JMenu();
        formMenu = new javax.swing.JMenu();
        addForm = new javax.swing.JMenuItem();
        delForm = new javax.swing.JMenuItem();
        infMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Accountant");
        setResizable(false);

        statniyBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        statniyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/document.png"))); // NOI18N
        statniyBtn.setText("Штатний розпис");
        statniyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        statniyBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statniyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statniyBtnActionPerformed(evt);
            }
        });

        blankiTree.setBackground(java.awt.SystemColor.controlHighlight);
        blankiTree.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("JTree");
        blankiTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        blankiContainer.setViewportView(blankiTree);

        titleLbl.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        titleLbl.setForeground(new java.awt.Color(51, 51, 255));
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setText("Бланки звітності");

        vidomistBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        vidomistBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/document.png"))); // NOI18N
        vidomistBtn.setText("    Відомість");
        vidomistBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vidomistBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vidomistBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vidomistBtnActionPerformed(evt);
            }
        });

        oneDFBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        oneDFBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/document.png"))); // NOI18N
        oneDFBtn.setText("      1-ДФ");
        oneDFBtn.setActionCommand("       1-ДФ");
        oneDFBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oneDFBtn.setHideActionText(true);
        oneDFBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        oneDFBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneDFBtnActionPerformed(evt);
            }
        });

        mainMenu.setBorder(null);

        openMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/open.png"))); // NOI18N
        openMenu.setToolTipText("Відкрити .pdf файл");
        openMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openMenuMouseClicked(evt);
            }
        });
        mainMenu.add(openMenu);

        formMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/binder.png"))); // NOI18N
        formMenu.setToolTipText("Бланки звітності (додавання, видалення)");
        formMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        addForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/add_file.png"))); // NOI18N
        addForm.setText("Додати");
        addForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFormActionPerformed(evt);
            }
        });
        formMenu.add(addForm);

        delForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/del_file.png"))); // NOI18N
        delForm.setText("Видалити");
        delForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delFormActionPerformed(evt);
            }
        });
        formMenu.add(delForm);

        mainMenu.add(formMenu);

        infMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/information.png"))); // NOI18N
        infMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infMenuMouseClicked(evt);
            }
        });
        mainMenu.add(infMenu);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(blankiContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(statniyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vidomistBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(oneDFBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(blankiContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statniyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(oneDFBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vidomistBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void statniyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statniyBtnActionPerformed
        StatniyFrame.getInstance().setVisible(true);
    }//GEN-LAST:event_statniyBtnActionPerformed

    private void openMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openMenuMouseClicked
        JFileChooser fileopen = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PDF files", "pdf");
        fileopen.setFileFilter(filter);
        fileopen.setAcceptAllFileFilterUsed(false);
        int ret = fileopen.showDialog(null, "Відкрити файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            PagePrintPreviewFrame.getInstance(DisplayPDFPage.getPDFFromFile(fileopen.getSelectedFile().toString())).setVisible(true);
            PagePrintPreviewFrame.menuSave.setVisible(false);
            PagePrintPreviewFrame.printFile = fileopen.getSelectedFile();
        } else {
        }


    }//GEN-LAST:event_openMenuMouseClicked

    private void addFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFormActionPerformed
        addBlankFrame.getInstance().setVisible(true);
    }//GEN-LAST:event_addFormActionPerformed

    private void delFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delFormActionPerformed
        delBlankFrame.getInstance().setVisible(true);
    }//GEN-LAST:event_delFormActionPerformed

    private void vidomistBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vidomistBtnActionPerformed
        VidomistForm.getInstance().setVisible(true);
    }//GEN-LAST:event_vidomistBtnActionPerformed

    private void oneDFBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneDFBtnActionPerformed
        OneDFForm.getInstance().setVisible(true);
    }//GEN-LAST:event_oneDFBtnActionPerformed

    private void infMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infMenuMouseClicked
        infoForm.getInstance().setVisible(true);
    }//GEN-LAST:event_infMenuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                }
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addForm;
    private javax.swing.JScrollPane blankiContainer;
    private static javax.swing.JTree blankiTree;
    private javax.swing.JMenuItem delForm;
    private static javax.swing.JMenu formMenu;
    private javax.swing.JMenu infMenu;
    private javax.swing.JMenuBar mainMenu;
    private static javax.swing.JButton oneDFBtn;
    private javax.swing.JMenu openMenu;
    private static javax.swing.JButton statniyBtn;
    private javax.swing.JLabel titleLbl;
    private static javax.swing.JButton vidomistBtn;
    // End of variables declaration//GEN-END:variables
}
