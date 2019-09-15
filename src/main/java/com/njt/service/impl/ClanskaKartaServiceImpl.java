/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service.impl;

import com.njt.entity.ClanskaKarta;
import com.njt.entity.Termin;
import com.njt.repository.ClanskaKartaRepository;
import com.njt.repository.TerminRepository;
import com.njt.service.ClanskaKartaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Roki
 */
@Service
@Transactional
public class ClanskaKartaServiceImpl implements ClanskaKartaService {

    @Autowired
    ClanskaKartaRepository clanskaKartaRepository;

    @Autowired
    TerminRepository terminRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public List<ClanskaKarta> findAll() {
        return clanskaKartaRepository.findAll();
    }

    @Override
    public ClanskaKarta findById(int id) {
        Optional<ClanskaKarta> clanskaKarta = clanskaKartaRepository.findById(id);
        if (clanskaKarta.isPresent()) {
            return clanskaKarta.get();
        }
        return null;
    }

    @Override
    public ClanskaKarta saveOrUpdate(ClanskaKarta clanskaKarta) {
        ClanskaKarta ck = findById(clanskaKarta.getClanskaKartaID());

        if (ck != null) {

            terminRepository.deleteByClanskaKartaClanskaKartaID(ck.getClanskaKartaID());

            if (clanskaKarta.getTermini() != null) {
                for (Termin termin : clanskaKarta.getTermini()) {
                    termin.setClanskaKarta(new ClanskaKarta(clanskaKarta.getClanskaKartaID(), null, null, null, 0, null, null));
                }
                terminRepository.saveAll(clanskaKarta.getTermini());
            }

            clanskaKarta.setTrening(clanskaKarta.getTrening());
            clanskaKarta.setKorisnik(clanskaKarta.getKorisnik());

            clanskaKartaRepository.save(clanskaKarta);
            return clanskaKarta;

        } else {
            clanskaKarta = clanskaKartaRepository.save(clanskaKarta);
            if (clanskaKarta.getTermini() != null) {

                for (Termin termin : clanskaKarta.getTermini()) {
                    termin.setClanskaKarta(new ClanskaKarta(clanskaKarta.getClanskaKartaID(), null, null, null, 0, null, null));
                }
                terminRepository.saveAll(clanskaKarta.getTermini());
            }

            return clanskaKarta;
        }
    }

    @Override
    public List<ClanskaKarta> search(String korisnik, String trening, String status) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<ClanskaKarta> clanskaKarta = cq.from(ClanskaKarta.class);

        List<Predicate> predicates = new ArrayList<>();

        if (korisnik != null) {
            predicates.add(qb.equal(clanskaKarta.get("korisnik").get("imePrezime"), korisnik));
        }
        if (trening != null) {
            predicates.add(qb.equal(clanskaKarta.get("trening").get("nazivTreninga"), trening));
        }
        if (status != null) {
            predicates.add(qb.like(clanskaKarta.get("status"), status + "%"));
        }

        cq.select(clanskaKarta).where(predicates.toArray(new Predicate[]{}));
        return entityManager.createQuery(cq).getResultList();
    }
}
