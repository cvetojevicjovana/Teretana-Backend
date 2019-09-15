/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Roki
 */
@Entity
public class Termin implements Serializable {

    @EmbeddedId
    private TerminID terminID;

    @Temporal(TemporalType.DATE)
    private Date datumOdrzavanja;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "UTC")
    private Date vremeOdrzavanja;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("clanskaKartaID")
    @JoinColumn
    @JsonIgnore
    private ClanskaKarta clanskaKarta;

    public Termin() {
    }

    public Termin(TerminID terminID, Date datumOdrzavanja, Date vremeOdrzavanja, ClanskaKarta clanskaKarta) {
        this.terminID = terminID;
        this.datumOdrzavanja = datumOdrzavanja;
        this.vremeOdrzavanja = vremeOdrzavanja;
        this.clanskaKarta = clanskaKarta;
    }

    public TerminID getTerminID() {
        return terminID;
    }

    public void setTerminID(TerminID terminID) {
        this.terminID = terminID;
    }

    public Date getDatumOdrzavanja() {
        return datumOdrzavanja;
    }

    public void setDatumOdrzavanja(Date datumOdrzavanja) {
        this.datumOdrzavanja = datumOdrzavanja;
    }

    public Date getVremeOdrzavanja() {
        return vremeOdrzavanja;
    }

    public void setVremeOdrzavanja(Date vremeOdrzavanja) {
        this.vremeOdrzavanja = vremeOdrzavanja;
    }

    public ClanskaKarta getClanskaKarta() {
        return clanskaKarta;
    }

    public void setClanskaKarta(ClanskaKarta clanskaKarta) {
        this.clanskaKarta = clanskaKarta;
    }

}
