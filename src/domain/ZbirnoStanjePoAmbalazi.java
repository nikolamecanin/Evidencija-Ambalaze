/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author xMx
 */
public class ZbirnoStanjePoAmbalazi {
    private String ime_prezime;
    private String jmbg;
    private int kolicina;
    private String broj_telefona;
    public ZbirnoStanjePoAmbalazi() {
    }

    public ZbirnoStanjePoAmbalazi(String ime_prezime,String jmbg, int kolicina,String broj_telefona) {
        this.jmbg = jmbg;
        this.ime_prezime = ime_prezime;
        this.kolicina = kolicina;
        this.broj_telefona = broj_telefona;
    }

    public String getIme_prezime() {
        return ime_prezime;
    }

    public void setIme_prezime(String ime_prezime) {
        this.ime_prezime = ime_prezime;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getBroj_telefona() {
        return broj_telefona;
    }

    public void setBroj_telefona(String broj_telefona) {
        this.broj_telefona = broj_telefona;
    }
    
    
}
