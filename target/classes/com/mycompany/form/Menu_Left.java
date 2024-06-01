/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.form;

import com.mycompany.component.Item_People;
import com.mycompany.swing.ScrollBar;
import net.miginfocom.swing.MigLayout;

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
        init();
    }
    
    private void init(){
        lpScroller.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout());
        showPeople();
        menuPeople.setSelected(true);
    }

    private void showPeople(){
        menuList.removeAll();
        for (int i =0;i<50;i++){
            menuList.add(new Item_People("People "+i), "wrap");
        }
        refresh();
    }
    private void showRoom(){
        menuList.removeAll();
        for (int i =0;i<50;i++){
            menuList.add(new Item_People("Room "+i), "wrap");
        }
        refresh();
    }
    
    private void refresh(){
        repaint();
        revalidate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuLPane = new javax.swing.JLayeredPane();
        menuPeople = new com.mycompany.component.MenuButton();
        menuRoom = new com.mycompany.component.MenuButton();
        lpScroller = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(255, 255, 255));

        menuLPane.setLayout(new java.awt.GridLayout(1, 2));

        menuPeople.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/icons8-people-45.png"))); // NOI18N
        menuPeople.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/icons8-people-45-colored.png"))); // NOI18N
        menuPeople.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/icons8-people-45.png"))); // NOI18N
        menuPeople.setMaximumSize(new java.awt.Dimension(100, 43));
        menuPeople.setMinimumSize(new java.awt.Dimension(100, 43));
        menuPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPeopleActionPerformed(evt);
            }
        });
        menuLPane.add(menuPeople);

        menuRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/icons8-room-45.png"))); // NOI18N
        menuRoom.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/icons8-room-45-colored.png"))); // NOI18N
        menuRoom.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/resources/icon/icons8-room-45.png"))); // NOI18N
        menuRoom.setMaximumSize(new java.awt.Dimension(100, 43));
        menuRoom.setMinimumSize(new java.awt.Dimension(100, 43));
        menuRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRoomActionPerformed(evt);
            }
        });
        menuLPane.add(menuRoom);

        lpScroller.setBackground(new java.awt.Color(255, 255, 255));
        lpScroller.setBorder(null);
        lpScroller.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        lpScroller.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lpScroller.setOpaque(false);

        menuList.setBackground(new java.awt.Color(248, 248, 248));
        menuList.setOpaque(true);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        lpScroller.setViewportView(menuList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menuLPane, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lpScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menuLPane, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(495, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(52, Short.MAX_VALUE)
                    .addComponent(lpScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPeopleActionPerformed
        menuPeople.setSelected(true);
        menuRoom.setSelected(false);
        
        showPeople();
    }//GEN-LAST:event_menuPeopleActionPerformed

    private void menuRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRoomActionPerformed
        showRoom();
        menuPeople.setSelected(false);
        menuRoom.setSelected(true);
    }//GEN-LAST:event_menuRoomActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane lpScroller;
    private javax.swing.JLayeredPane menuLPane;
    private javax.swing.JLayeredPane menuList;
    private com.mycompany.component.MenuButton menuPeople;
    private com.mycompany.component.MenuButton menuRoom;
    // End of variables declaration//GEN-END:variables
}
