/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokerstats.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class WinningNumbers implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    
    @Column(name = "LIST")
    private int[] list;
    
    @Column(name = "BONUS")
    private int[] bonus;
   
    //==========================================================================
    
    public int getId() { return  id; }
    public void setId(int id) {this.id = id;}
    
    public  int[] getList() { return list; }
    public void setList(int[] list) {this.list = list;}
    
    public  int[] getBonus() { return  bonus;}
    public void setBonus(int[] bonus) {this.bonus = bonus;}

    //==========================================================================
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WinningNumbers)) {
            return false;
        }
        WinningNumbers other = (WinningNumbers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String
                .format(
                    "ΝΙΚΗΤΗΡΙΑ ΣΤΗΛΗ\n" 
                    +"\tΤυχεροί αριθμοί: %s\n" 
                    +"\tΑριθμός τζόκερ:  %s\n",
                    Arrays.toString(list), 
                    Arrays.toString(bonus)
                );
    }
}
