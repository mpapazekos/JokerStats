/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokerstats;

import frames.firstscreen;
import javax.swing.UIManager;

import org.jfree.ui.RefineryUtilities;

public class JokerStatsMain {

    public static void main(String[] args) throws Exception {

        // Ορισμός εμφανισης παραθύρων εφαρμογής
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       
        // Δημιουργία αντικειμένου αρχικής οθόνης
        firstscreen startScreen = new firstscreen();
        
        // Μετατόπιση παραθύρου στο κέντρο της οθόνης
        RefineryUtilities.centerFrameOnScreen(startScreen);
             
        // Εμφανιση αρχικής οθόνης στον χρήστη
        startScreen.setVisible(true);    
    }  
}
