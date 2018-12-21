package ua.uznu.vargha;

import java.io.IOException;
import java.nio.file.Files;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author 89502
 */
public class addBlankFrame extends javax.swing.JFrame {

    private static addBlankFrame obj = null;
    byte[] byteArray;
    String extension;

    public addBlankFrame() {
        initComponents();
        
    super.setIconImage(new ImageIcon(getClass().getResource("/ua/uznu/vargha/abacus.png")).getImage());
    }

    public static addBlankFrame getInstance() {
        if (obj == null) {
            obj = new addBlankFrame();
        } else {
        }
        return obj;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        categoryTxt = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chooseFileBtn = new javax.swing.JButton();
        okBtn = new javax.swing.JButton();
        cancleBtn = new javax.swing.JButton();
        nazvaTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));

        categoryTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        categoryTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Місячний", "Квартальний", "Річний" }));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Назва звіта");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Період подання");

        chooseFileBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        chooseFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/open_document.png"))); // NOI18N
        chooseFileBtn.setText("Виберіть файл");
        chooseFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileBtnActionPerformed(evt);
            }
        });

        okBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        okBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/ok.png"))); // NOI18N
        okBtn.setText("Готово");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        cancleBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cancleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/cancel.png"))); // NOI18N
        cancleBtn.setText("Відміна ");
        cancleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleBtnActionPerformed(evt);
            }
        });

        nazvaTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(nazvaTxt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(categoryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 223, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cancleBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(chooseFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nazvaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(categoryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chooseFileBtn)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancleBtn)
                    .addComponent(okBtn))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 457, 200));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
         if (checkCorrectValues() && ConnectDB.insertToDB(nazvaTxt.getText(),
                 categoryTxt.getSelectedItem().toString(), extension, byteArray)) {
                this.dispose();
                JOptionPane.showMessageDialog(null, "Успішно додано");
                MainFrame.setJTreeModel();
            } else {
                this.dispose();
                JOptionPane.showMessageDialog(null, "Виникла помилка при додаванні!");
            }
    }//GEN-LAST:event_okBtnActionPerformed
    private boolean checkCorrectValues() {
        if (byteArray != null
                && !nazvaTxt.getText().trim().equals("") && nazvaTxt.getText().length() > 2) {
            return true;
        } else {
            return false;
        }

    }
    private void chooseFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileBtnActionPerformed
        JFileChooser fileopen = new JFileChooser();
        fileopen.setAcceptAllFileFilterUsed(false);
        fileopen.addChoosableFileFilter(new FileNameExtensionFilter("MS Office документи", "docx", "xlsx", "doc", "xls"));
        fileopen.addChoosableFileFilter(new FileNameExtensionFilter("PDF документи", "pdf"));
        int rel = fileopen.showDialog(null, "Імпортувати");
        if (rel == JFileChooser.APPROVE_OPTION) {
            try {
                String filename = fileopen.getSelectedFile().toString();
                System.out.println(filename);
                byteArray = Files.readAllBytes(fileopen.getSelectedFile().toPath());
                extension = filename.substring(filename.lastIndexOf("."), filename.length());

            } catch (IOException ex) {
                System.err.println(ex);
            }
        } else {
            System.out.println("Cancel");
        }
    }//GEN-LAST:event_chooseFileBtnActionPerformed

    private void cancleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancleBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancleBtn;
    private javax.swing.JComboBox<String> categoryTxt;
    private javax.swing.JButton chooseFileBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nazvaTxt;
    private javax.swing.JButton okBtn;
    // End of variables declaration//GEN-END:variables
}
