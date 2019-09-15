/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.njt.entity.TerminID;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Roki
 */
public class TerminDTO implements Serializable {

    private TerminID terminID;
    private Date datumOdrzavanja;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "UTC")
    private Date vremeOdrzavanja;

    @JsonIgnore
    private ClanskaKartaDTO clanskaKarta;

    public TerminDTO() {
    }

    public TerminDTO(TerminID terminID, Date datumOdrzavanja, Date vremeOdrzavanja, ClanskaKartaDTO clanskaKarta) {
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

    public ClanskaKartaDTO getClanskaKarta() {
        return clanskaKarta;
    }

    public void setClanskaKarta(ClanskaKartaDTO clanskaKarta) {
        this.clanskaKarta = clanskaKarta;
    }

}
