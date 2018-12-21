/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.uznu.vargha;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author 89502
 */
public class delBlankFrame extends javax.swing.JFrame {

    private static delBlankFrame obj = null;
    private JMenu closeMenu = new JMenu();

    /**
     * Creates new form delBlankFrame
     */
    private delBlankFrame() {

        initComponents();
        addCloseMenu();
        super.setIconImage(new ImageIcon(getClass().getResource("/ua/uznu/vargha/abacus.png")).getImage());
        loadNamesToTable();

    }

    public static delBlankFrame getInstance() {
        if (obj == null) {
            obj = new delBlankFrame();
        }
        return obj;
    }

    /**
     * Завантаження в таблицю
     */
    private void loadNamesToTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) blankiTable.getModel();
            model.setRowCount(0);
            ConnectDB.selectForDelete();
            for (int i = 0; i < ConnectDB.names.size(); i++) {
                model.addRow(new Object[]{ConnectDB.names.get(i)});
            }

            setScrollable(blankiTable);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    /**
     * Налаштування сувій
     *
     * @param table таблиця
     */
    private void setScrollable(JTable table) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int width = 0;
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, 0);
            Component comp = table.prepareRenderer(renderer, row, 0);
            width = Math.max(comp.getPreferredSize().width, width);
        }
        width += 5;
        table.getColumn("Бланки").setPreferredWidth(width);
        table.getColumn("Бланки").setMinWidth(360);
        table.getColumn("Бланки").setMaxWidth(width);

    }

    private void closeMenuMouseClicked(java.awt.event.MouseEvent evt) {
        super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blankiContainer = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        blankiTable = new javax.swing.JTable();
        mainMenu = new javax.swing.JMenuBar();
        delMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        blankiContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 2));
        blankiContainer.setLayout(new javax.swing.BoxLayout(blankiContainer, javax.swing.BoxLayout.LINE_AXIS));

        blankiTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        blankiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Бланки"
            }
        ));
        blankiTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(blankiTable);

        blankiContainer.add(scrollPane);

        getContentPane().add(blankiContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 250));

        mainMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        delMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/delete.png"))); // NOI18N
        delMenu.setToolTipText("Видалити з бази даних");
        delMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delMenuMouseClicked(evt);
            }
        });
        mainMenu.add(delMenu);

        setJMenuBar(mainMenu);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void delMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delMenuMouseClicked
        int row = blankiTable.getSelectedRow();
        int cel = blankiTable.getSelectedColumn();

        if (row >= 0) {
                    int reply = JOptionPane.showOptionDialog(null, "Ви дійсно бахаєте видалити ?", "Видалення",
                JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE, 
        null, 
        new String[]{"Так", "Ні"}, "default"); 
        if (reply == JOptionPane.YES_OPTION) {
            if (ConnectDB.deleteFromDB(blankiTable.getValueAt(row, cel).toString())) {
                JOptionPane.showMessageDialog(null, "Успішно видалено", "Інформація", JOptionPane.INFORMATION_MESSAGE);
                loadNamesToTable();
                MainFrame.setJTreeModel();
            } else {
                JOptionPane.showMessageDialog(null, "Не вдалося видалити", "Помилка", JOptionPane.ERROR_MESSAGE);
            }
            
        }else{}
        } else {
            JOptionPane.showMessageDialog(null, "Виберіть рядок", "Інформація", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_delMenuMouseClicked

    private void addCloseMenu() {

        closeMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ua/uznu/vargha/close.png")));
        closeMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMenuMouseClicked(evt);
            }
        });
        mainMenu.add(Box.createGlue());
        mainMenu.add(closeMenu);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel blankiContainer;
    private javax.swing.JTable blankiTable;
    private javax.swing.JMenu delMenu;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
