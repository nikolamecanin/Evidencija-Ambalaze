/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author xMx
 */
public class Zaduzenje {
    
    
    private Long id;
    private Ambalaza ambalaza;
    private Kupac kupac;
    private LocalDateTime vreme_zaduzenja;
    private int kolicina;
    private String napomena;
    public Zaduzenje() {
    }

    public Zaduzenje(Ambalaza ambalaza, Kupac kupac, LocalDateTime vreme_zaduzenja, int kolicina,String napomena) {
        
        this.ambalaza = ambalaza;
        this.kupac = kupac;
        this.vreme_zaduzenja = vreme_zaduzenja;
        this.kolicina = kolicina;
        this.napomena = napomena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ambalaza getAmbalaza() {
        return ambalaza;
    }

    public void setAmbalaza(Ambalaza ambalaza) {
        this.ambalaza = ambalaza;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public LocalDateTime getVreme_zaduzenja() {
        return vreme_zaduzenja;
    }

    public void setVreme_zaduzenja(LocalDateTime vreme_zaduzenja) {
        this.vreme_zaduzenja = vreme_zaduzenja;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zaduzenje other = (Zaduzenje) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Zaduzenje{" + "id=" + id + ", ambalaza=" + ambalaza + ", kupac=" + kupac + ", vreme_zaduzenja=" + vreme_zaduzenja + ", kolicina=" + kolicina + '}';
    }

    
    
    
    
}
