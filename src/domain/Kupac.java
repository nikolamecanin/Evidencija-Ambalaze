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
public class Kupac {

    private Long id;
    private String ime_prezime;
    private String jmbg;
    private String adresa;
    private String broj_telefona;

    public Kupac() {
    }

    public Kupac(String ime_prezime,String jmbg, String adresa, String broj_telefona) {
        this.ime_prezime = ime_prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
        this.broj_telefona = broj_telefona;
    }

    public Kupac(Long id, String ime_prezime, String jmbg, String adresa, String broj_telefona) {
        this.id = id;
        this.ime_prezime = ime_prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
        this.broj_telefona = broj_telefona;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme_prezime() {
        return ime_prezime;
    }

    public void setIme_prezime(String ime_prezime) {
        this.ime_prezime = ime_prezime;
    }

   

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBroj_telefona() {
        return broj_telefona;
    }

    public void setBroj_telefona(String broj_telefona) {
        this.broj_telefona = broj_telefona;
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
        final Kupac other = (Kupac) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return ime_prezime;
                }

    
    
    
    
    
}
