/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.component;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author User
 */
public class MenuButton extends JButton {
    
    private Icon iconSimple;
    private Icon iconSelected;
    
    public MenuButton(){
        setContentAreaFilled(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    
    public Icon getIconSimple(){
        return iconSimple;
    }
    
    public Icon getIconSelected(){
        return iconSelected;
    }
    
    public void setIconSimple(Icon iconSimple){
        this.iconSimple = iconSimple;
    }
    
    public void setIconSelected(Icon iconSelected){
        this.iconSelected = iconSelected;
    }
    
    @Override
    public void setSelected(boolean b) {
        super.setSelected(b); 
        if(b){
            setIcon(iconSelected);
        } else{
            setIcon(iconSimple);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isSelected()){
            g.setColor(new Color(252, 137, 124));
            g.fill3DRect(0, getHeight()-2, getWidth(), getHeight(), true);
        }
    }


}
