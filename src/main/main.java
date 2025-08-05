/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import domain.*;
import DBBroker.DatabaseBroker;
import form.FrmMain;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/** 
 *
 * @author xMx
 */
public class main {
    public static void main(String[] args) {
        
        JFrame main = new FrmMain();
        main.setTitle("Ambalaza");
        main.setSize(950, 650);
        main.setLocationRelativeTo(null); 
        main.setExtendedState(JFrame.MAXIMIZED_BOTH);
        main.setVisible(true);
        
            
        
        
    }
}
