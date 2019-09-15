/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Roki
 */
@Entity
public class ClanskaKarta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clanskaKartaID;

    @Temporal(TemporalType.DATE)
    private Date datumUplate;

    @Temporal(TemporalType.DATE)
    private Date datumVazenja;

    private String status;
    private int brojIskoriscenihTermina;

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;

    @ManyToOne(fetch = FetchType.EAGER)
    private Korisnik korisnik;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "clanskaKarta", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Termin> termini;

    public ClanskaKarta() {
    }

    public ClanskaKarta(int clanskaKartaID, Date datumUplate, Date datumVazenja, String status, int brojIskoriscenihTermina, Trening trening, Korisnik korisnik) {
        this.clanskaKartaID = clanskaKartaID;
        this.datumUplate = datumUplate;
        this.datumVazenja = datumVazenja;
        this.status = status;
        this.brojIskoriscenihTermina = brojIskoriscenihTermina;
        this.trening = trening;
        this.korisnik = korisnik;
        this.termini = new ArrayList<>();
    }

    public int getClanskaKartaID() {
        return clanskaKartaID;
    }

    public void setClanskaKartaID(int clanskaKartaID) {
        this.clanskaKartaID = clanskaKartaID;
    }

    public Date getDatumUplate() {
        return datumUplate;
    }

    public void setDatumUplate(Date datumUplate) {
        this.datumUplate = datumUplate;
    }

    public Date getDatumVazenja() {
        return datumVazenja;
    }

    public void setDatumVazenja(Date datumVazenja) {
        this.datumVazenja = datumVazenja;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBrojIskoriscenihTermina() {
        return brojIskoriscenihTermina;
    }

    public void setBrojIskoriscenihTermina(int brojIskoriscenihTermina) {
        this.brojIskoriscenihTermina = brojIskoriscenihTermina;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public List<Termin> getTermini() {
        return termini;
    }

    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }

}
