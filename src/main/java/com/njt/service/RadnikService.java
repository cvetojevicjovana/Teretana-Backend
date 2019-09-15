/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service;

import com.njt.entity.Radnik;
import java.util.List;

/**
 *
 * @author Roki
 */
public interface RadnikService {

    public List<Radnik> findAll();

    public Radnik findById(int id);

    public Radnik findByUsernameAndPassword(String username, String password);

    public Radnik findByUsernamee(String username);
    
}
