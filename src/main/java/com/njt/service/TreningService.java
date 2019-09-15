/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service;

import com.njt.entity.Trening;
import java.util.List;

/**
 *
 * @author Roki
 */
public interface TreningService {

    public List<Trening> findAll();

    public Trening findById(int id);

    public void saveOrUdate(Trening trening);

    public List<Trening> search(int id, String naziv, String opis, double cena);
    
}
