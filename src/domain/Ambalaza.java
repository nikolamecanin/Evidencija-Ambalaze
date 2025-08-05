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
public class Ambalaza {


    private Long id;
    private String naziv;
    private int kapacitet;
    public Ambalaza() {
    }

    public Ambalaza(Long id,String naziv, int kapacitet) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.naziv = naziv;
    }

    public Ambalaza(String naziv, int kapacitet) {
        this.naziv = naziv;
        this.kapacitet = kapacitet;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
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
        final Ambalaza other = (Ambalaza) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
    
}
