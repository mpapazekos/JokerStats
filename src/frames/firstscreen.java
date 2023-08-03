/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javax.swing.JOptionPane;
import jokerstats.db.DrawDbManager;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author HP
 */
public class firstscreen extends javax.swing.JFrame {

    /**
     * Creates new form firstscreen
     */
    public firstscreen() {
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

        jPanel1 = new javax.swing.JPanel();
        manageDataBtn = new javax.swing.JButton();
        viewMonthlyStatsBtn = new javax.swing.JButton();
        viewStatisticsBtn = new javax.swing.JButton();
        exitAppBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TZOKER Stats");
        setBackground(new java.awt.Color(102, 0, 153));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setName(""); // NOI18N

        manageDataBtn.setBackground(new java.awt.Color(255, 255, 255));
        manageDataBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        manageDataBtn.setForeground(new java.awt.Color(102, 102, 102));
        manageDataBtn.setText("Διαχείριση Δεδομένων");
        manageDataBtn.setToolTipText("");
        manageDataBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageDataBtnMouseClicked(evt);
            }
        });

        viewMonthlyStatsBtn.setBackground(new java.awt.Color(255, 255, 255));
        viewMonthlyStatsBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewMonthlyStatsBtn.setForeground(new java.awt.Color(102, 102, 102));
        viewMonthlyStatsBtn.setText("Προβολή Δεδομένων ανά Μήνα");
        viewMonthlyStatsBtn.setToolTipText("");
        viewMonthlyStatsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewMonthlyStatsBtnMouseClicked(evt);
            }
        });

        viewStatisticsBtn.setBackground(new java.awt.Color(255, 255, 255));
        viewStatisticsBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewStatisticsBtn.setForeground(new java.awt.Color(102, 102, 102));
        viewStatisticsBtn.setText("Προβολή Στατιστικών & Εκτύπωση");
        viewStatisticsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewStatisticsBtnMouseClicked(evt);
            }
        });

        exitAppBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitAppBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exitAppBtn.setForeground(new java.awt.Color(102, 102, 102));
        exitAppBtn.setText("Έξοδος");
        exitAppBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitAppBtnMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ΣΤΑΤΙΣΤΙΚΑ ΤΖΟΚΕΡ");
        jLabel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(exitAppBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewStatisticsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                            .addComponent(viewMonthlyStatsBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manageDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(manageDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewMonthlyStatsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewStatisticsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitAppBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Event handler για την περίπτωση που 
     * ο χρήστης κανει κλικ στο κουμπί "Διαχείριση Δεδομένων".
     * Δημιουργείται ενα αντικείμενο της οθόνης manageData και 
     * εμφανίζεται στο χρήστη ενα νεο παράθυρο για την προβολή
     * και διαχειριση δεδομένων των παιχνιδιων ΤΖΟΚΕΡ
     */
    private void manageDataBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageDataBtnMouseClicked
        
        manageData manageDataScrn = new manageData();
        RefineryUtilities.centerFrameOnScreen(manageDataScrn);
        
        setVisible(false);
        dispose();
        
        manageDataScrn.setVisible(true);   
    }//GEN-LAST:event_manageDataBtnMouseClicked

    /**
     * Event handler για την περίπτωση που 
     * ο χρήστης κανει κλικ στο κουμπί "Προβολή ανά μήνα".
     * Δημιουργείται ενα αντικείμενο της οθόνης viewData και 
     * εμφανίζεται στο χρήστη ενα νεο παράθυρο για την προβολή
     * των παιχνιδιων ΤΖΟΚΕΡ για ενα συγκεκριμενο μηνα 
     */
    private void viewMonthlyStatsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMonthlyStatsBtnMouseClicked
    
        viewData viewDataScrn = new viewData();
        RefineryUtilities.centerFrameOnScreen(viewDataScrn);
        
        setVisible(false);
        dispose();
        
        viewDataScrn.setVisible(true);   
    }//GEN-LAST:event_viewMonthlyStatsBtnMouseClicked

    /**
     * Event handler για την περίπτωση που 
     * ο χρήστης κανει κλικ στο κουμπί "Εξοδος".
     * Εμφανίζεται ενα μηνυμα επαληθευσης στον χρηστη και 
     * αν το αποδεχθεί η εφαρμογή τερματίζει τη λειτουργία της.
     */
    private void exitAppBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitAppBtnMouseClicked

        int res = 
            JOptionPane.showConfirmDialog(this, "Εξοδος απο την εφαρμογή?", "ΕΞΟΔΟΣ" , JOptionPane.YES_NO_OPTION);
        
        if (res == 0) {
            setVisible(false);
            DrawDbManager.closeDB();
            dispose();
        }
    }//GEN-LAST:event_exitAppBtnMouseClicked

    /**
     * Event handler για την περίπτωση που 
     * ο χρήστης κανει κλικ στο κουμπί "Προβολή Στατιστικών & Εκτύπωση".
     * Δημιουργείται ενα αντικείμενο της οθόνης statisticsView και 
     * εμφανίζεται στο χρήστη ενα νεο παράθυρο για την προβολή
     * στατιστικων ολων των παιχνιδιων ΤΖΟΚΕΡ μεχρι τωρα και 
     * με τη δυνατοτητα εκτυπωσης αυτων σε αρχειο pdf.
     */
    private void viewStatisticsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewStatisticsBtnMouseClicked
        
        statisticsView viewStatsScrn = new statisticsView();
        RefineryUtilities.centerFrameOnScreen(viewStatsScrn);
        
        setVisible(false);
        dispose();
        
        viewStatsScrn.setVisible(true);   
    }//GEN-LAST:event_viewStatisticsBtnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitAppBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton manageDataBtn;
    private javax.swing.JButton viewMonthlyStatsBtn;
    private javax.swing.JButton viewStatisticsBtn;
    // End of variables declaration//GEN-END:variables
}