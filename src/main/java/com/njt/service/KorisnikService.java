/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service;

import com.njt.entity.Korisnik;
import java.util.List;

/**
 *
 * @author Roki
 */
public interface KorisnikService {

    public List<Korisnik> findAll();

    public Korisnik findById(int id);

    public void saveOrUpdate(Korisnik korisnik);

    public List<Korisnik> search(int id, String imePrezime, String radnik);
    
}
