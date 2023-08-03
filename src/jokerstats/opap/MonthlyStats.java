/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokerstats.opap;

import java.time.Month;
import java.util.List;
import jokerstats.model.Draw;

public class MonthlyStats {
    
    private final Month month;
    
    private final int year;
    
    //[R3]
    // Για κάθε μήνα μας ενδιαφέρουν συγκεντρωτικά δεδομένα, συγκεκριμένα:
    
    // Πόσα παιχνίδια έγιναν
    private final int totalDraws;
    
    // Πόσα χρήματα διανεμήθηκαν
    private final double totalDistributedAmount;
    
    // Πόσα ΤΖΑΚ-ΠΟΤ έγιναν
    private final int totalJackpotAmount;
    
    private final List<Draw> drawsInMonth;
    
    //=========================================================================
    
    public MonthlyStats(int year, Month month, List<Draw> drawsInMonth) {
        
        double distributedAmnt = 0.0;
        int jackpotAmnt = 0;
        
        for(Draw draw : drawsInMonth) {
            distributedAmnt += draw.getTotalDistributedAmnt();
            jackpotAmnt += draw.getTotalJackpotAmnt();
        }
        
        this.year = year;
        this.month = month;
        this.drawsInMonth = drawsInMonth;
        this.totalDraws = drawsInMonth.size();
        this.totalDistributedAmount = distributedAmnt;
        this.totalJackpotAmount = jackpotAmnt;
    }
    
    //=========================================================================
    
    public Month getMonth() { return month; }
    
    public int getTotalDraws() { return totalDraws; }
    
    public double getTotalDistributedAmnt() { return totalDistributedAmount; }
    
    public int getTotalJackpotAmnt() { return totalJackpotAmount; }
    
    public List<Draw> getDrawsInMonth() { return drawsInMonth; }
    
    @Override 
    public String toString() {
        return  
            String.format(
                "%s %s\n"
                +"|- Total Draws: %d\n"
                +"|- Total Jackpot: %d\n"
                +"|- Total Distributed Amount(euro): %.3f\n",
                year, month, totalDraws,
                totalJackpotAmount, totalDistributedAmount
            );
    }
    
}
