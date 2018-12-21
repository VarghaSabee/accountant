/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.uznu.vargha;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ua.uznu.vargha.pdfjob.CreateVidomistPDF;

/**
 *
 * @author 89502
 */
public class VidomistSettings extends javax.swing.JFrame {

    private static VidomistSettings obj = null;

    /**
     * Creates new form VidomistSettings
     */

    private VidomistSettings() {
        initComponents();
        super.setIconImage(new ImageIcon(getClass().getResource("/ua/uznu/vargha/abacus.png")).getImage());
        pdvTxt.setText(String.valueOf(VidomistObj.getPodatok()));
        vpdvTxt.setText(String.valueOf(VidomistObj.getvPodatok()));
        profTxt.setText(String.valueOf(VidomistObj.getProfSpilka()));
        nazvaUstanTxt.setText("Тисаашванська с/р");

        for (int i = 1900; i < 2201; i++) {
            rikList.addItem("" + i);
        }
    }

    public static VidomistSettings getInstance() {
        if (obj == null) {
            obj = new VidomistSettings();
        }
        return obj;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        okBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pdvTxt = new javax.swing.JTextField();
        vpdvTxt = new javax.swing.JTextField();
        profTxt = new javax.swing.JTextField();
        nazvaUstanTxt = new javax.swing.JTextField();
        misyacList = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        rikList = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));

        okBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        okBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/ok.png"))); // NOI18N
        okBtn.setText("Готово");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        CancelBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/cancel.png"))); // NOI18N
        CancelBtn.setText("Відміна");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Податок в %");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Військовій збір в %");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Профспілка в %");

        pdvTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        vpdvTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        profTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        nazvaUstanTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nazvaUstanTxt.setText("Тисаашванська");
        nazvaUstanTxt.setToolTipText("Назва установи");

        misyacList.setEditable(true);
        misyacList.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        misyacList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "січень", "лютий", "березень", "квітень", "травень", "червень", "липень", "серпень", "вересень", "жовтень", "листопад", "грудень" }));
        misyacList.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("За");

        rikList.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rikList.setToolTipText("Рік");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(misyacList, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rikList, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nazvaUstanTxt)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vpdvTxt)
                            .addComponent(pdvTxt)
                            .addComponent(profTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okBtn)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pdvTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vpdvTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(profTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nazvaUstanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(misyacList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(rikList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelBtn)
                    .addComponent(okBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        super.dispose();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        if (VidomistForm.isDouble(pdvTxt.getText()) && VidomistForm.isDouble(vpdvTxt.getText()) && VidomistForm.isDouble(profTxt.getText())
                && !nazvaUstanTxt.getText().trim().equals("") && nazvaUstanTxt.getText().length() > 4) {
            VidomistObj.setPodatok(Double.parseDouble(pdvTxt.getText()));
            VidomistObj.setvPodatok(Double.parseDouble(vpdvTxt.getText()));
            VidomistObj.setProfSpilka(Double.parseDouble(profTxt.getText()));
            CreateVidomistPDF.nazvaUstanovy = nazvaUstanTxt.getText();
            CreateVidomistPDF.DATE[0] = misyacList.getSelectedItem().toString();
            CreateVidomistPDF.DATE[1] = rikList.getSelectedItem().toString();
            super.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Помилка у форматі!", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_okBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JComboBox<String> misyacList;
    private javax.swing.JTextField nazvaUstanTxt;
    private javax.swing.JButton okBtn;
    private javax.swing.JTextField pdvTxt;
    private javax.swing.JTextField profTxt;
    public static javax.swing.JComboBox<String> rikList;
    private javax.swing.JTextField vpdvTxt;
    // End of variables declaration//GEN-END:variables
}
