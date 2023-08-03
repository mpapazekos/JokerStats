/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokerstats.db;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import jokerstats.model.Draw;

public class DrawDbManager {
    
    private static final String PERSISTENCE_UNIT = "DrawDB";
   
    @PersistenceContext
    private static final EntityManager entityManager = 
                                Persistence
                                    .createEntityManagerFactory(PERSISTENCE_UNIT)
                                    .createEntityManager();
    
    //============================================================================
    
    //[R2] 
    // διαγραφή παιχνιδιών εντός ορισμένου εύρους ημερομηνιών
    public static void removeDrawsInDateRange(LocalDate fromDate, LocalDate toDate) {
        
        // Μετατροπή ημερομηνιών σε millisecond (UTC),
        // για την σύγκριση με το πεδίο drawTime της κλάσης Draw.
        Long start = fromDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Long end   =   toDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        
        // Βρίσκονται όλα τα drawId των κληρώσεων(draw) στη βάση δεδομένων,
        // για τις οποιες η κλήρωση πραγματοποιήθηκε(drawTime) μέσα στο έυρος ημερομηνιών που δίνεται.
        List<Integer> drawsIDsInDateRange =
                entityManager
                    .createQuery("SELECT d.drawId FROM Draw d WHERE d.drawTime BETWEEN :start AND :end")
                    .setParameter("start", start)
                    .setParameter("end", end)
                    .getResultList();

        // Διαγραφή κληρώσεων απο τη βάση δεδομένων,
        // μέσω των drawId
        for(Integer drawId : drawsIDsInDateRange) 
            removeDraw(drawId);
    }
    
    // Διαγραφή πολλαπλών κληρώσεων στη βάση δεδομένων,
    // οι οποίες δινονται σε μορφή λιστας.
    public static String removeDraws(List<Draw> draws) {
        
        StringBuilder log = new StringBuilder();
        
        for(Draw d : draws) {
            String result = removeDraw(d.getDrawId());
            
            log.append(result).append("\n");
        } 
       
        return log.toString();
    }
    
    //[R2] 
    // Με την επιλογή της διαγραφής δεδομένων παιχνιδιού, 
    // διαγράφονται από τη βάση δεδομένων τα σχετικά δεδομένα 
    // βάσει του id του εν λόγω παιχνιδιού .
    public static String removeDraw(Integer drawId) {
        
        //Μηνυμα αποτελέσματος διαδικασίας
        String resultMsg = " Η κλήρωση με κωδικό ";
        
        //Εναρξη συναλλαγής με τη βάση
        entityManager.getTransaction().begin();
        
        Draw drawToRemove = 
            entityManager.find(Draw.class, drawId);
        
        if (drawToRemove != null) {
            
            entityManager.remove(drawToRemove);
          
            resultMsg +=
                drawToRemove.getDrawId() + " διαγράφηκε επιτυχώς!";
        } else 
            resultMsg = 
                drawId + " δεν βρέθηκε... ";
        
        // Λήξη συναλαγής
        entityManager.getTransaction().commit();

        return resultMsg;
    }
    
    // Αποθήκευση πολλαπλών κληρώσεων στη βάση δεδομένων,
    // οι οποίες δινονται σε μορφή λιστας.
    public static String saveDraws(List<Draw> draws) {
        
        StringBuilder log = new StringBuilder();
        
        for(Draw d : draws) {
            String result = saveDraw(d);
            
            log.append(result).append("\n");
        } 
       
        return log.toString();
    }
    
    //[R2]
    //ο χρήστης έχει τη δυνατότητα να αποθηκεύσει τα δεδομένα που ανακτήθηκαν 
    //από το api, σε ΒΔ. 
    public static String saveDraw(Draw draw) {
    
        String msg = 
            "Η κλήρωση με κωδικό " + draw.getDrawId() ;
    
        //Έλεγχος ύπαρξης στη βάση δεδομένων των δεδομένων αυτών 
        if(entityManager.find(Draw.class, draw.getDrawId()) == null) {
            
            // αν δεν υπάρχουν, αποθηκεύονται στη βάση δεδομένων.
       
            entityManager.getTransaction().begin();
        
            entityManager.persist(draw);

            entityManager.getTransaction().commit();
            
            return msg + " αποθηκεύτηκε επιτυχώς!";
        } else
            return msg + " εναι ήδη αποθηκευμένη...";
    } 
    
    
    // Κλεισιμο βασης δεδομενων που ειναι
    // συνδεδεμένη με τον entityManager της κλασης
    public static void closeDB() {
        if(entityManager.isOpen()) 
            entityManager.close();
    }
}