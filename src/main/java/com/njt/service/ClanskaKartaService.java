/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service;

import com.njt.entity.ClanskaKarta;
import java.util.List;


/**
 *
 * @author Roki
 */

public interface ClanskaKartaService  {

    public List<ClanskaKarta> findAll();

    public ClanskaKarta findById(int id);

    public ClanskaKarta saveOrUpdate(ClanskaKarta clanskaKarta);

    public List<ClanskaKarta> search(String korisnik, String trening, String status);
    
}
