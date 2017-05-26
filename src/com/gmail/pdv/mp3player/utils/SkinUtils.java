package com.gmail.pdv.mp3player.utils;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class SkinUtils {
    
    public static void changeSkin (Component comp, LookAndFeel look){
        try {
            UIManager.setLookAndFeel(look);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SkinUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(comp);        
        
    }
    
    public static void changeSkin (Component comp, String look){
        try {
            UIManager.setLookAndFeel(look);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SkinUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(comp); 
        
        
    }

}
