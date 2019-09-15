/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Roki
 */
public class ClanskaKartaDTO implements Serializable {

    private int clanskaKartaID;
    private Date datumUplate;
    private Date datumVazenja;
    private String status;
    private int brojIskoriscenihTermina;
    private TreningDTO trening;
    private KorisnikDTO korisnik;
    private List<TerminDTO> termini;

    public ClanskaKartaDTO() {
    }

    public ClanskaKartaDTO(int clanskaKartaID, Date datumUplate, Date datumVazenja, String status, int brojIskoriscenihTermina, TreningDTO trening, KorisnikDTO korisnik) {
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

    public TreningDTO getTrening() {
        return trening;
    }

    public void setTrening(TreningDTO trening) {
        this.trening = trening;
    }

    public KorisnikDTO getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(KorisnikDTO korisnik) {
        this.korisnik = korisnik;
    }

    public List<TerminDTO> getTermini() {
        return termini;
    }

    public void setTermini(List<TerminDTO> termini) {
        this.termini = termini;
    }

}
