/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Objects;

/**
 *
 * @author xMx
 */
public class ZbirnoStanje {
    private String naziv_ambalaze;
    private int kolicina;
    private Long id;

    public ZbirnoStanje(Long id,String naziv_ambalaze, int kolicina) {
        this.id= id;
        this.naziv_ambalaze = naziv_ambalaze;
        this.kolicina = kolicina;
    }
    
    
  

    public ZbirnoStanje() {
    }

    public String getNaziv_ambalaze() {
        return naziv_ambalaze;
    }

    public void setNaziv_ambalaze(String naziv_ambalaze) {
        this.naziv_ambalaze = naziv_ambalaze;
    }

    

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        return "ZbirnoStanje{" + "ambalaza=" + naziv_ambalaze + ", kolicina=" + kolicina + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        final ZbirnoStanje other = (ZbirnoStanje) obj;
        return Objects.equals(this.naziv_ambalaze, other.naziv_ambalaze);
    }
    
    
    
    
}
