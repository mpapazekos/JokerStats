package jokerstats.opap.statistics;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.*;

import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

// https://api.opap.gr/games/v1.0/5104/statistics
//
// -> definitions -> infostoreGameStatisticsDTO
public class JokerStatistics {
    
    // Οι βασικές πληροφορίες για το ΤΖΟΚΕΡ
    private StatsHeader header;
    
    // Στατιστικά στοιχεία για κάθε εναν απο 
    // τους αριθμούς που μπορει να εμφανιστούν σε 
    // μια κλήρωση ΤΖΟΚΕΡ [1-45]
    private StatsNumber[] numbers;
    
    // Στατιστικά στοιχεία για κάθε εναν απο 
    // τους μπονους αριθμούς που μπορει να εμφανιστούν σε 
    // μια κλήρωση ΤΖΟΚΕΡ [1-20]
    private StatsNumber[] bonusNumbers;
    
    //==========================================================================
    
    public StatsHeader getHeader() { return header; }
    public void setHeader(StatsHeader header) { this.header = header; }
    
    public StatsNumber[] getNumbers() {return numbers; }
    public void setNumbers(StatsNumber[] numbers) {this.numbers = numbers;}
    
    public StatsNumber[] getBonusNumbers() {return bonusNumbers; }
    public void setBonusNumbers(StatsNumber[] bonusNumbers) {this.bonusNumbers = bonusNumbers;}
     
    //==========================================================================
    
    public TableModel numbersTableModel() {
        return statsNumbersModel(numbers);
    }
    
    public TableModel bonusNumbersTableModel() {
        return statsNumbersModel(bonusNumbers);
    }
    
    // Eπιστρέφει ενα αντικείμενο tableModel για τα
    // στατιστικα στοιχεία αριθμων ΤΖΟΚΕΡ, 
    // ωστε να μπορούν να χρησιμοποιηθούν σε πινακα του
    // γραφικού περιβάλλοντος της εφαρμογής.
    private TableModel statsNumbersModel(StatsNumber[] stats) {
        
        DefaultTableModel statsModel = new DefaultTableModel();
        
        statsModel.addColumn("Αριθμός");
        statsModel.addColumn("Εμφανίσεις");
        statsModel.addColumn("Καθυστερήσεις");
        
        for(StatsNumber sn : stats) 
            statsModel.addRow(sn.getAsTableRow());
        
        return statsModel;
    }

    //==========================================================================
    
    // Δημιουργία αρχειου pdf μεσω της βιβλιοθήκης "com.itextpdf". 
    // Αποθήκευται στον αρχικό φακελο του project.
    public boolean generatePDF(){
        try {
            PdfDocument pdf = new PdfDocument(new PdfWriter("stats.pdf"));
            Document document = new Document(pdf);
            
            document.add(new Paragraph(toString()));
            document.close();
            
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }   
    } 
    
    @Override
    public String toString() {
       return 
            new StringBuilder()
                .append(header)
                .append("\n\n>> Joker: statistics for first five numbers [1~45] <<")
                .append("\n------------------------------------------------------\n")
                .append(statsTable(numbers))
                .append("\n\n>> Joker: statistics for bonus number [1~20] <<")
                .append("\n------------------------------------------------------\n")
                .append(statsTable(bonusNumbers))
                .toString();
    }  
    
    // Επιστρέφει τα στατιστικα στοιχεια σε μορφή πινακα ως String
    private String statsTable(StatsNumber[] stats) {
        
        // Ονοματα στηλών πίνακα
        StringBuilder builder = 
                new StringBuilder()
                    .append("\n|  Number  | Occurences | Delays  |")
                    .append("\n---------------------------------------------");
    
        // Δημιουργια γραμμής για κάθε αριθμό
        // και προσθηκη στον πίνακα.
        Arrays
            .stream(stats)
            .forEach(ns -> {  
                    builder.append(
                        String.format(
                            "%n|    %2d          |     %3d          |    %2d         |%n",
                            ns.getNumber(), ns.getOccurrences(), ns.getDelays()
                        )
                    );
                    builder.append("-----------------------------------------------");
                }
            );
        
        return builder.toString();
    }
}
