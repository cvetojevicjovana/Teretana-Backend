/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Roki
 */
@Embeddable
public class TerminID implements Serializable {

    private int clanskaKartaID;
    private int redniBroj;

    public TerminID() {
    }

    public TerminID(int clanskaKartaID, int redniBroj) {
        this.clanskaKartaID = clanskaKartaID;
        this.redniBroj = redniBroj;
    }

    public int getClanskaKartaID() {
        return clanskaKartaID;
    }

    public void setClanskaKartaID(int clanskaKartaID) {
        this.clanskaKartaID = clanskaKartaID;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

}
