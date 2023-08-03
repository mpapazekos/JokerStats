/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokerstats.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PrizeCategory implements Serializable {

    @JoinColumn(name = "DRAW_ID", referencedColumnName = "DRAWID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Draw drawId;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    
    // Τυπος κατηγορίας
    @Column(name = "CATEGORYTYPE")
    private String categoryType;
    
    // Συνολικό ποσό που διαμοιράστηκε στους νικητές
    @Column(name = "DISTRIBUTED")
    private Double distributed;
    
    // Κέρδη ανα επιτυχία
    @Column(name = "DIVIDENT")
    private Double divident;
    
    // Κέρδη τζακποτ
    @Column(name = "JACKPOT")
    private Double jackpot;
    
    // Αριθμός επιτυχιων 
    @Column(name = "WINNERS")
    private Integer winners;
    
  
    //==========================================================================
    
    public int getId() { return  id; }
    public void setId(int id) {this.id = id;}
    
    public String getCategoryType() { return categoryType; }
    public void setCategoryType(String categoryType) { this.categoryType = categoryType; }
    
    public double getDivident() { return divident; }
    public void setDivident(double divident) { this.divident = divident; }
    
    public double getDistributed() { return distributed; }
    public void setDistributed(double distributed) { this.distributed = distributed; }
 
    public double getJackpot() { return jackpot; }
    public void setJackpot(double jackpot) { this.jackpot = jackpot; }
    
    public Integer getWinners() { return winners; }
    public void setWinners(Integer winners) { this.winners = winners; }

    
    //==========================================================================
    
    @Override 
    public String toString() {
        return String.format(
                    "\nΤύπος Κατηγορίας: %s\n" +
                    "\tΕπιτυχόντες: %d\n" +
                    "\tΚέρδη ανά επιτυχία: %,.2f €\n",
                    categoryType, winners, divident
                );
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrizeCategory)) {
            return false;
        }
        PrizeCategory other = (PrizeCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public PrizeCategory() {
    }

    public Draw getDrawId() {
        return drawId;
    }

    public void setDrawId(Draw drawId) {
        this.drawId = drawId;
    }
}
