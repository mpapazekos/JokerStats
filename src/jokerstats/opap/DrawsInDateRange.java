/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokerstats.opap;

import java.util.List;
import jokerstats.model.Draw;

// Κλαση που αντιστοιχεί το μερικό αποτέλεσμα 
// της κλήσης https://api.opap.gr/draws/v3.0/5104/draw-date/{fromDate}/{toDate}
public class DrawsInDateRange {
    
    //Λίστα με τις κληρώσεις για το εύρος ημερομηνιών 
    private List<Draw> content;
    
    public List<Draw> getContent() { return content; }
    public void  setContent(List<Draw> content) { this.content = content;}
    
    public boolean hasContent() {
        return !content.isEmpty();
    }
 }
