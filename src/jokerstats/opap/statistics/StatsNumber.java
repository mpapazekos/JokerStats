/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokerstats.opap.statistics;


// https://api.opap.gr/numerics/v1.0/api-swagger
//
// -> definitions -> infostoreOccurrenceDelayNumberPosition
public class StatsNumber {
    
    // Αριθμός τον οποίο αφορουν τα στατιστικά
    private final Integer number;
    
    // Πληθος εμφανισεων αριθμού
    private final Integer occurrences;
    
    // Πλήθος καθυστερήσεων αριθμού
    private final Integer delays;
     
    public StatsNumber(Integer occurences, Integer delays, Integer number) {
        this.occurrences = occurences;
        this.delays = delays;
        this.number = number;
    }
    
    public Integer getOccurrences() { return occurrences; }
    public Integer getDelays() { return delays; }
    public Integer getNumber() { return number; }
    
    // Επιστρέφει ενα array με τα στοιχεία της κλάσης
    // για την χρήση στο γραφικό περιβαλλον της εφαρμογής.
    public Object[] getAsTableRow() {
        return new Object[] { number, occurrences, delays} ; 
    }
}
