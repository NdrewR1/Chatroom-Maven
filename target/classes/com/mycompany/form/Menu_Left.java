/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.form;

/**
 *
 * @author User
 */
public class Menu_Left extends javax.swing.JPanel {

    /**
     * Creates new form Menu_Left
     */
    public Menu_Left() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        menuButton1 = new com.mycompany.component.MenuButton();
        menuButton2 = new com.mycompany.component.MenuButton();

        jLayeredPane1.setLayout(new javax.swing.BoxLayout(jLayeredPane1, javax.swing.BoxLayout.LINE_AXIS));

        menuButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/icons8-people-45-colored.png"))); // NOI18N
        menuButton1.setMaximumSize(new java.awt.Dimension(100, 43));
        menuButton1.setMinimumSize(new java.awt.Dimension(100, 43));
        menuButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(menuButton1);

        menuButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/icons8-room-45.png"))); // NOI18N
        menuButton2.setMaximumSize(new java.awt.Dimension(100, 43));
        menuButton2.setMinimumSize(new java.awt.Dimension(100, 43));
        menuButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton2ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(menuButton2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(487, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuButton1ActionPerformed

    private void menuButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private com.mycompany.component.MenuButton menuButton1;
    private com.mycompany.component.MenuButton menuButton2;
    // End of variables declaration//GEN-END:variables
}
