/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokerstats.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import static javax.persistence.CascadeType.ALL;

import org.eclipse.persistence.annotations.PrivateOwned;


@Entity
public class Draw implements Serializable{

    @Id
    @Column(name = "DRAWID")
    private Integer drawId;
    
    @Column(name = "DRAWTIME")
    private Long drawTime; // "Draw time in UTC in milliseconds
    
    @Column(name = "STATUS")
    private String status;
    
    //[R2] Οι λεπτομέρειες που μας ενδιαφέρουν να αντληθούν για κάθε παιχνίδι είναι οι ακόλουθες:
 
    // Τυχεροί αριθμοί (νικητήρια στήλη)
    @JoinColumn(name = "WINNINGNUMBERS_ID", referencedColumnName = "ID")
    @OneToOne(cascade = ALL, orphanRemoval = true)
    private WinningNumbers winningNumbers;
    
    // Βασικές κατηγορίες επιτυχιών, 
    // όπου για κάθε κατηγορία θέλουμε να γνωρίζουμε 
    // τον αριθμό επιτυχιών και τα κέρδη ανά επιτυχία.
    @JoinColumn(name = "DRAW_ID", referencedColumnName = "DRAWID")
    @OneToMany(cascade = ALL, orphanRemoval = true)
    @PrivateOwned
    private List<PrizeCategory> prizeCategories;
    
    
    //==========================================================================
    
    public int getDrawId() { return drawId; }
    public void setDrawId(int drawId) { this.drawId = drawId; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public Long getDrawTime() { return drawTime; }
    public void setDrawTime(Long drawTime) { this.drawTime = drawTime; }
 
    public WinningNumbers getWinningNumbers() { return winningNumbers; }
    public void setWinningNumbers(WinningNumbers winningNumbers) { this.winningNumbers = winningNumbers; }
    
    public List<PrizeCategory> getPrizeCategories() { return prizeCategories; }
    public void setPrizeCategories(List<PrizeCategory> prizeCategories) { this.prizeCategories = prizeCategories; }
    
    //==========================================================================
    
    /**
     * Μετατρέπει το πεδίο drawTime(Draw time in UTC in milliseconds)
     * στην αντίστοιχη ημερομηνία με μορφή "YEAR-MONTH-DAY"
     * @return ημερομηνία που πραγματοποιήθηκε η κλήρωση σε μορφή String
     */
    public String getDrawDate() {  
        //πηγή:
        // https://mkyong.com/java8/java-8-convert-epoch-time-milliseconds-to-localdate-or-localdatetime/
        return Instant
                .ofEpochMilli(drawTime)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .toString();
    
    }
    
    //[R3] Επιστρέφει το συνολίκό πλήθος των τζάκποτ
    // που έγιναν στην συγκεκριμένη κλήρωση
    public int getTotalJackpotAmnt() {
        int totalJackpotAmnt = 0;
        
        for(PrizeCategory ctg : prizeCategories) 
            if(ctg.getJackpot() > 0.0) 
                totalJackpotAmnt++; 
        
        return totalJackpotAmnt;
    }
    
    //[R3] Επιστρέφει το συνολίκό ποσό που διανεμήθηκε  
    //στην συγκεκριμένη κλήρωση
    public double getTotalDistributedAmnt() {
        double totalDistributedAmnt = 0.0;
        
        for(PrizeCategory ctg : prizeCategories) 
            totalDistributedAmnt += ctg.getDistributed();
        
        return totalDistributedAmnt;
    }
    
    //==========================================================================
    
    // [R1] Επιστρεφει τις πληροφοριες για τους τυχερους αριθμους(winningNumbers)
    // και τις κατηγοριες επιτυχιας (prizeCategories) που αφορουν αυτη την κληρωση.
    public String details() {
        return  String.format(
                    "------------------------------------------------\n"
                    +"%s\n"
                    +"------------------------------------------------\n"
                    + "ΚΑΤΗΓΟΡΙΕΣ ΕΠΙΤΥΧΙΩΝ\n\t%s",
                    winningNumbers, prizeCategories
                );
    }
    
    @Override
    public String toString() {
        return "Κλήρωση: ["+ drawId + "] - Ημ/νια: (" + getDrawDate() + ") ";   
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drawId != null ? drawId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Draw)) {
            return false;
        }
        Draw other = (Draw) object;
        if ((this.drawId == null && other.drawId != null) || (this.drawId != null && !this.drawId.equals(other.drawId))) {
            return false;
        }
        return true;
    }
}
