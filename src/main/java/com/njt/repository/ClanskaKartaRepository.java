/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.repository;

import com.njt.entity.ClanskaKarta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roki
 */

@Repository
public interface ClanskaKartaRepository extends JpaRepository<ClanskaKarta, Integer> {
    
}
