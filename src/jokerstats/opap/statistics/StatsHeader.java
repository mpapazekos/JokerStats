/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokerstats.opap.statistics;

import java.time.Instant;
import java.time.ZoneId;

// https://api.opap.gr/numerics/v1.0/api-swagger
// -> definitions -> infostoreStatisticsHeader
public class StatsHeader {
    
    // Ημερομηνία απο την οποία αρχίζει η καταμέτρηση των στατιστικών (yyyy - MM - dd) 
    private String fromLocalDate;
    
    // Ημερομηνία απο την οποία τελειώνει η καταμέτρηση των στατιστικών (yyyy - MM - dd) 
    private String toLocalDate;
    
    //==========================================================================
    
    // Ημερομηνία απο την οποία αρχίζει η καταμέτρηση των στατιστικών (UTC in milliseconds) 
    private final Long dateFrom;
    
     // Ημερομηνία απο την οποία τελειώνει η καταμέτρηση των στατιστικών (UTC in milliseconds)) 
    private final Long dateTo;
    
    // Πληθος κληρώσεων που πραγματοποιήθηκαν μεταξύ dateFrom και dateTo
    private final Integer drawCount;
    
    public StatsHeader(Long dateFrom, Long dateTo, Integer drawCount) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.drawCount = drawCount;
    }
    
    //==========================================================================
    
    public Long getDateFrom() { return dateFrom; }
    public Long getDateTo() { return dateTo; }
    public Integer getDrawCount() { return drawCount; }
    
    @Override
    public String toString() { 
        return 
            "\nFrom ["+getLocalDateFrom()+"] until ["+getLocalDateTo()+"]\nTotal draws: "+drawCount; 
    }
    
    public String getLocalDateFrom() {
        
        if (fromLocalDate == null) 
            fromLocalDate = epochSecToDate(dateFrom);
        
        return fromLocalDate; 
    }
    
    public String getLocalDateTo() {
        
        if (toLocalDate == null) 
            toLocalDate = epochSecToDate(dateTo);
        
        return toLocalDate; 
    }
    
    // Μετατρέπει μια ημερομηνια της μορφής (UTC in milliseconds)  
    // σε ημερομηνία της μορφής (yyyy - MM - dd)  
    private String epochSecToDate(long l) {
        return Instant
                .ofEpochSecond(l)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .toString();
    } 
}
