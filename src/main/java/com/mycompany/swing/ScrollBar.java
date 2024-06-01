/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.swing;

import javax.swing.JScrollBar;

/**
 *
 * @author User
 */
public class ScrollBar extends JScrollBar {
    public ScrollBar(){
        setUI(new ModernScrollBarUI());
    }
}
