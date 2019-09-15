/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.dto;

import java.io.Serializable;

/**
 *
 * @author Roki
 */
public class KorisnikDTO implements Serializable {

    private int korisnikID;
    private String imePrezime;
    private String email;
    private String telefon;
    private RadnikDTO radnik;

    public KorisnikDTO() {
    }

    public KorisnikDTO(int korisnikID, String imePrezime, String email, String telefon, RadnikDTO radnik) {
        this.korisnikID = korisnikID;
        this.imePrezime = imePrezime;
        this.email = email;
        this.telefon = telefon;
        this.radnik = radnik;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public RadnikDTO getRadnik() {
        return radnik;
    }

    public void setRadnik(RadnikDTO radnik) {
        this.radnik = radnik;
    }

}
