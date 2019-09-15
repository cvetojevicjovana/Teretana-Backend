/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Roki
 */
@Entity
public class Trening implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treningID")
    private int treningID;

    private String nazivTreninga;
    private int brojTermina;
    private double cena;
    private String opis;

    public Trening() {
    }

    public Trening(int treningID, String nazivTreninga, int brojTermina, double cena, String opis) {
        this.treningID = treningID;
        this.nazivTreninga = nazivTreninga;
        this.brojTermina = brojTermina;
        this.cena = cena;
        this.opis = opis;
    }

    public int getTreningID() {
        return treningID;
    }

    public void setTreningID(int treningID) {
        this.treningID = treningID;
    }

    public String getNazivTreninga() {
        return nazivTreninga;
    }

    public void setNazivTreninga(String nazivTreninga) {
        this.nazivTreninga = nazivTreninga;
    }

    public int getBrojTermina() {
        return brojTermina;
    }

    public void setBrojTermina(int brojTermina) {
        this.brojTermina = brojTermina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

}
