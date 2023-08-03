/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import com.toedter.calendar.JDateChooser;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import jokerstats.db.DrawDbManager;

import jokerstats.model.Draw;
import jokerstats.opap.DrawsInDateRange;
import jokerstats.opap.OpapApiHandler;

import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author HP
 */
public class manageData extends javax.swing.JFrame {

    // Οι κληρώσεις που εχουν ληφθεί τελευταίες απο το API
    private Draw[] drawsInMemory;
    
    /**
     * Creates new form manageData
     */
    public manageData() {
        
        initComponents();
        
        // Αποκτηση σημερινής ημερομηνίας 
        Calendar today = Calendar.getInstance();
        today.clear(Calendar.HOUR); 
        today.clear(Calendar.MINUTE); 
        today.clear(Calendar.SECOND);
        
        Date todayDate = today.getTime();
        
        // Αρχικοποιηση πεδίου ημερομηνιας "Απο: "
        fromDateChooser.setDate(todayDate);
        fromDateChooser.setMaxSelectableDate(todayDate);
        
        // Αρχικοποιηση πεδίου ημερομηνιας "Εως: "
        toDateChooser.setDate(todayDate);
        toDateChooser.setMaxSelectableDate(todayDate);  
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        drawIdTxtField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        backToMainBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultsList = new javax.swing.JList<>();
        getByIDBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTxtPane = new javax.swing.JTextPane();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        toDateChooser = new com.toedter.calendar.JDateChooser();
        showByDateRangeBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        saveDrawListBtn = new javax.swing.JButton();
        saveSelectedDrawBtn = new javax.swing.JButton();
        deleteDrawListBtn = new javax.swing.JButton();
        deleteSelectedDrawBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Διαχείριση Δεδομένων");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ΕΙΣΑΓΩΓΗ στη ΒΔ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Κωδικός κλήρωσης :");

        drawIdTxtField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Από:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("'Εως:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ΔΙΑΓΡΑΦΗ  απο τη BΔ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Χρονική περίοδος");

        backToMainBtn.setBackground(new java.awt.Color(204, 0, 0));
        backToMainBtn.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        backToMainBtn.setText("↩ ΑΡΧΙΚΗ");
        backToMainBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToMainBtnMouseClicked(evt);
            }
        });

        resultsList.setModel(new DefaultListModel<Draw>());
        resultsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        resultsList.setToolTipText("");
        resultsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                resultsListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(resultsList);

        getByIDBtn.setBackground(new java.awt.Color(0, 0, 204));
        getByIDBtn.setText("Προβολή");
        getByIDBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getByIDBtnMouseClicked(evt);
            }
        });

        resultTxtPane.setEditable(false);
        jScrollPane1.setViewportView(resultTxtPane);

        fromDateChooser.setMinSelectableDate(new java.util.Date(946681297000L));

        toDateChooser.setMaxSelectableDate(Date.from(Instant.now()));
        toDateChooser.setMinSelectableDate(fromDateChooser.getDate());

        showByDateRangeBtn.setBackground(new java.awt.Color(0, 0, 255));
        showByDateRangeBtn.setText("Προβολή");
        showByDateRangeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showByDateRangeBtnMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Λίστα Αποτελεσμάτων ");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Λεπτομέρειες Παιχνιδιού");

        saveDrawListBtn.setBackground(new java.awt.Color(0, 102, 51));
        saveDrawListBtn.setText("Εισαγωγή ΟΛΩΝ των αποτελεσμάτων");
        saveDrawListBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveDrawListBtnMouseClicked(evt);
            }
        });

        saveSelectedDrawBtn.setBackground(new java.awt.Color(0, 102, 51));
        saveSelectedDrawBtn.setText("Εισαγωγή ΕΠΙΛΕΓΜΕΝΗΣ κλήρωσης");
        saveSelectedDrawBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveSelectedDrawBtnMouseClicked(evt);
            }
        });

        deleteDrawListBtn.setBackground(new java.awt.Color(153, 102, 0));
        deleteDrawListBtn.setText("Διαγραφή ΟΛΩΝ των αποτελεσμάτων");
        deleteDrawListBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteDrawListBtnMouseClicked(evt);
            }
        });

        deleteSelectedDrawBtn.setBackground(new java.awt.Color(153, 102, 0));
        deleteSelectedDrawBtn.setText("Διαγραφή ΕΠΙΛΕΓΜΕΝΗΣ κλήρωσης");
        deleteSelectedDrawBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteSelectedDrawBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(drawIdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getByIDBtn))
                            .addComponent(jLabel9)
                            .addComponent(backToMainBtn)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(showByDateRangeBtn))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveSelectedDrawBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveDrawListBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteDrawListBtn)
                            .addComponent(deleteSelectedDrawBtn)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(backToMainBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(drawIdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getByIDBtn))
                .addGap(34, 34, 34)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showByDateRangeBtn)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveSelectedDrawBtn)
                    .addComponent(deleteSelectedDrawBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveDrawListBtn)
                    .addComponent(deleteDrawListBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Event handler για την περίπτωση που 
    * ο χρήστης κανει κλικ στο κουμπί "Προβολή" που αφορά 
    * την ευρεση μιας κλήρωσης με βάση τον κωδικό της
    */
    private void getByIDBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getByIDBtnMouseClicked

        // Λαμβάνεται απο το APΙ η κλήρωση 
        // με το συγκεκριμένο ID που δοθηκε απο τον χρήστη
        Optional<Draw> drawOption = OpapApiHandler.getDrawById(drawIdTxtField.getText());

        // Σε περίπτωση επιτυχής λήψης
        if (drawOption.isPresent()) {
            
            // Ανανεώνεται η τιμή των αποθηκευμεύνων κληρώσεων 
            drawsInMemory = new Draw[]{ drawOption.get() };
            
            // Αδείαζουν τα πεδια της λιστας αποτελεσματων
            // και των λεπτομερειών για μια κλήρωση
            resultTxtPane.setText("");
            resultsList.clearSelection();
            resultsList.removeAll(); 
            
            // Ανανεωνονται τα στοιχεία της λιστας αποτελεσμάτων
            resultsList.setListData(drawsInMemory);
        }
        else {
            // Διαφορετικά εμφανίζεται μήνυμα αποτυχίας στον χρήστη
            JOptionPane.showMessageDialog(this, "Δεν βρέθηκε κλήρωση για το συγκεκριμένο κωδικό", "ΛΑΝΘΑΣΜΕΝΟΣ ΚΩΔΙΚΟΣ", JOptionPane.ERROR_MESSAGE);
            drawIdTxtField.setText("");
        }
    }//GEN-LAST:event_getByIDBtnMouseClicked

    /**
     * Event handler για την περίπτωση που 
     * ο χρήστης επιλεξει μια κλήρωση απο τη λίστα αποτελεσμάτων.
     * Εμφανίζονται οι λεπτομέρεις για την συγκεκριμένη κλήρωση στο 
     * πεδίο resultTxtPane.
     */
    private void resultsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_resultsListValueChanged
        if(!evt.getValueIsAdjusting()) {
            Draw selectedDraw = resultsList.getSelectedValue();
            if (selectedDraw != null)
                resultTxtPane.setText(selectedDraw.details());
        }     
    }//GEN-LAST:event_resultsListValueChanged
  
    /**
     * Event handler για την περίπτωση που 
     * ο χρήστης κανει κλικ στο κουμπί "< ΑΡΧΙΚΗ".
     * Κλείνει το τρέχον παράθυρο και εμφανίζει στον χρήστη την αρχική οθόνη.
     */
    private void backToMainBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToMainBtnMouseClicked
       
        firstscreen startscreen = new firstscreen();
        RefineryUtilities.centerFrameOnScreen(startscreen);

        setVisible(false);
        dispose();

        startscreen.setVisible(true);
    }//GEN-LAST:event_backToMainBtnMouseClicked

    /**
    * Event handler για την περίπτωση που 
    * ο χρήστης κανει κλικ στο κουμπί "Προβολή" που αφορά 
    * την ευρεση κληρώσεων μεσα σε ενα ευρος ημερομηνιών
    */
    private void showByDateRangeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showByDateRangeBtnMouseClicked
        
        // Ημερομηνία "Απο: " ως LocalDate
        LocalDate fromDate = getLocalDate(fromDateChooser);
        
        // Ημερομηνία "Εως: " ως LocalDate
        LocalDate toDate   = getLocalDate(toDateChooser);
        
        // Εαν ο χρηστης δεν εχει βαλει τις ημερομηνίες αναποδα
        if(!fromDate.isAfter(toDate))  {
            
            // Λαμβάνονται οι κληρώσεις για το ευρος ημερομηνιών απο το API
            Optional<DrawsInDateRange> draws = OpapApiHandler.getDrawsInDateRange(fromDate, toDate);
                  
            // Εαν η λήψη ήταν επιτυχής
            if(draws.isPresent() && draws.get().hasContent()) {

                // Ανανεώνεται η τιμή των αποθηκευμένων κληρώσεων    
                List<Draw> drawList = draws.get().getContent();
  
                drawsInMemory = drawList.toArray(new Draw[drawList.size()]);
   
                // Αδείαζουν τα πεδια της λιστας αποτελεσματων
                // και των λεπτομερειών για μια κλήρωση
                resultTxtPane.setText("");
                resultsList.clearSelection();
                resultsList.removeAll();
                
                // Ανανεωνονται τα στοιχεία της λιστας αποτελεσμάτων
                resultsList.setListData(drawsInMemory);      
            }
            else // Εαν υπάρχει σφάλμα κατα την λήψη εμφανίζεται αντίστοιχο μήνυμα
                JOptionPane.showMessageDialog(this, 
                  "Δεν βρέθηκαν παιχνίδια για το συγκεκριμένο εύρος ημερομηνιών", 
                  "ΔΕΝ ΒΡΕΘΗΚΑΝ ΠΑΙΧΝΙΔΙΑ ΤΖΟΚΕΡ", 
                  JOptionPane.ERROR_MESSAGE
                );  
        }
        else // Εαν ο χρήστης εβαλε ανάποδα τις ημερομηνίες εμφανίζεται αντίστοιχο μήνυμα
            JOptionPane.showMessageDialog(this, 
                  "Για κοίτα ξανά τις ημερομηνίες...", 
                  "ΛΑΝΘΑΣΜΕΝΕΣ ΗΜΕΡΟΜΗΝΙΕΣ", 
                  JOptionPane.ERROR_MESSAGE
            );
    }//GEN-LAST:event_showByDateRangeBtnMouseClicked

    /**
    * Event handler για την περίπτωση που 
    * ο χρήστης κανει κλικ στο κουμπί "Εισαγωγή ολων των αποτελεσμάτων",
    * το οποιο αφορά την αποθήκευση ολων των κληρώσεων στη λίστα αποτελεμάτων, 
    * στη βάση δεδομένων.
    */
    private void saveDrawListBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveDrawListBtnMouseClicked
    
        // Εαν υπαρχουν κληρώσεις  στη λίστα
        if(drawsInMemory != null) {
            
            // Εμφανίζεται ενα μήνυμα στο χρήστη για να επιβεβαιωθεί η ενέργεια
            int res = 
                JOptionPane.showConfirmDialog(this, "Είστε σίγουροι?", "Αποθήκευση λίστας αποτελεσμάτων", JOptionPane.WARNING_MESSAGE);

            // Εφόσον ο χρήστης πατήσει ΟΚ
            if(res == 0) {
                // Γινεται αποθηκευση των δεδομένων στη βαση και καταγράφεται
                // το αποτέλεσμα στη μεταβλητή result
                String result = DrawDbManager.saveDraws(Arrays.asList(drawsInMemory));
                
                // Εμφανίζεται στον χρήστη το αποτέλεσμα της ενέργειας
                JOptionPane.showMessageDialog(this, result, "Αποτέλεσμα", JOptionPane.INFORMATION_MESSAGE);
            }   
        }
    }//GEN-LAST:event_saveDrawListBtnMouseClicked

    /**
    * Event handler για την περίπτωση που 
    * ο χρήστης κανει κλικ στο κουμπί "Εισαγωγή επιλεγμενης κλήρωσης",
    * το οποιο αφορά την αποθήκευση της επιλεγμενης κληρώσης απο τη λίστα αποτελεμάτων, 
    * στη βάση δεδομένων.
    */
    private void saveSelectedDrawBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveSelectedDrawBtnMouseClicked
         
        // Η επιλεγμενη κλήρωση 
        Draw selectedDraw = resultsList.getSelectedValue();
        
        // Εαν πατήθηκε το κουμπί και υπαρχει επιλεγμενη κληρωση
        if( selectedDraw != null) {
            
            // Εμφανίζεται ενα μήνυμα στο χρήστη για να επιβεβαιωθεί η ενέργεια
            int res = 
                JOptionPane.showConfirmDialog(this, "Είστε σίγουροι?", "Αποθήκευση επιλεγμένου παιχνιδιού", JOptionPane.WARNING_MESSAGE);

            // Εφόσον ο χρήστης πατήσει ΟΚ
            if(res == 0) {
                // Γινεται αποθηκευση των δεδομένων στη βαση και καταγράφεται
                // το αποτέλεσμα στη μεταβλητή result
                String result =  DrawDbManager.saveDraw(selectedDraw);
                
                // Εμφανίζεται στον χρήστη το αποτέλεσμα της ενέργειας
                JOptionPane.showMessageDialog(this, result, "Αποτέλεσμα", JOptionPane.INFORMATION_MESSAGE);
            }   
        }
    }//GEN-LAST:event_saveSelectedDrawBtnMouseClicked

    /**
    * Event handler για την περίπτωση που 
    * ο χρήστης κανει κλικ στο κουμπί "Διαγραφή ολων των αποτελεσμάτων",
    * το οποιο αφορά την διαγραφή ολων των κληρώσεων στη λίστα αποτελεμάτων
    * απο τη βάση δεδομένων.
    */
    private void deleteDrawListBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteDrawListBtnMouseClicked
        
        // Εαν υπαρχουν κληρώσεις στη λίστα
        if(drawsInMemory != null) {
            
            // Εμφανίζεται ενα μήνυμα στο χρήστη για να επιβεβαιωθεί η ενέργεια
            int res = 
                JOptionPane.showConfirmDialog(this, "Είστε σίγουροι?", "Διαγραφή λίστας αποτελεσμάτων", JOptionPane.WARNING_MESSAGE);

            // Εφόσον ο χρήστης πατήσει ΟΚ
            if(res == 0) {
                // Γινεται διαγραφή των δεδομένων στη βαση και καταγράφεται
                // το αποτέλεσμα στη μεταβλητή result
                String result = DrawDbManager.removeDraws(Arrays.asList(drawsInMemory));
                
                // Εμφανίζεται στον χρήστη το αποτέλεσμα της ενέργειας
                JOptionPane.showMessageDialog(this, result, "Αποτέλεσμα", JOptionPane.INFORMATION_MESSAGE);
            }   
        }
    }//GEN-LAST:event_deleteDrawListBtnMouseClicked
 
    /**
    * Event handler για την περίπτωση που 
    * ο χρήστης κανει κλικ στο κουμπί "Διαγραφή επιλεγμενης κλήρωσης",
    * το οποιο αφορά την διαγραφή της επιλεγμενης κληρώσης απο τη λίστα αποτελεμάτων 
    * απο τη βάση δεδομένων.
    */
    private void deleteSelectedDrawBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteSelectedDrawBtnMouseClicked
        
        // Η επιλεγμενη κλήρωση 
        Draw selectedDraw = resultsList.getSelectedValue();
        
        // Εαν πατήθηκε το κουμπί και υπαρχει επιλεγμενη κληρωση
        if( selectedDraw != null) {
            
            // Εμφανίζεται ενα μήνυμα στο χρήστη για να επιβεβαιωθεί η ενέργεια
            int res = 
                JOptionPane.showConfirmDialog(this, "Είστε σίγουροι?", "Διαγραφή επιλεγμένου παιχνιδιού", JOptionPane.WARNING_MESSAGE);

            // Εφόσον ο χρήστης πατήσει ΟΚ
            if(res == 0) {
                // Γινεται διαγραφή των δεδομένων στη βαση και καταγράφεται
                // το αποτέλεσμα στη μεταβλητή result
                String result = DrawDbManager.removeDraw(selectedDraw.getDrawId());
                
                // Εμφανίζεται στον χρήστη το αποτέλεσμα της ενέργειας
                JOptionPane.showMessageDialog(this, result, "Αποτέλεσμα", JOptionPane.INFORMATION_MESSAGE);
            }   
        }
    }//GEN-LAST:event_deleteSelectedDrawBtnMouseClicked

    // Χρησιμοποιείται για να μετατρέψει την τιμή των 
    // πεδίων ημερομηνίων που επιλέγει ο χρήστης, σε μορφή 
    // αντικειμένων LocalDate.
    private LocalDate getLocalDate(JDateChooser dateChooser) {
        return dateChooser
                    .getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMainBtn;
    private javax.swing.JButton deleteDrawListBtn;
    private javax.swing.JButton deleteSelectedDrawBtn;
    private javax.swing.JTextField drawIdTxtField;
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JButton getByIDBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextPane resultTxtPane;
    private javax.swing.JList<Draw> resultsList;
    private javax.swing.JButton saveDrawListBtn;
    private javax.swing.JButton saveSelectedDrawBtn;
    private javax.swing.JButton showByDateRangeBtn;
    private com.toedter.calendar.JDateChooser toDateChooser;
    // End of variables declaration//GEN-END:variables
}
