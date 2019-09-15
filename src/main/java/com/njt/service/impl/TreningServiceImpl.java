/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service.impl;

import com.njt.entity.Trening;
import com.njt.repository.TreningRepository;
import com.njt.service.TreningService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
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
public class TreningServiceImpl implements TreningService {

    @Autowired
    TreningRepository treningRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Trening> findAll() {
        return treningRepository.findAll();
    }

    @Override
    public Trening findById(int id) {
        Optional<Trening> trening = treningRepository.findById(id);

        if (trening.isPresent()) {
            return trening.get();
        }

        throw new EntityNotFoundException("Trening ne postoji!");
    }

    @Override
    public void saveOrUdate(Trening trening) {
        treningRepository.save(trening);
    }

    @Override
    public List<Trening> search(int id, String naziv, String opis, double cena) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<Trening> trening = cq.from(Trening.class);

        List<Predicate> predicates = new ArrayList<>();

        if (id != 0) {
            List<Trening> treninzi = new ArrayList<>();
            treninzi.add(findById(id));
            return treninzi;
        }
        if (naziv != null) {
            predicates.add(qb.like(trening.get("nazivTreninga"), naziv + "%"));
        }
        if (opis != null) {
            predicates.add(qb.like(trening.get("opis"), opis + "%"));
        }
        if (cena != 0) {
            predicates.add(qb.equal(trening.get("cena"), cena));
        }

        cq.select(trening).where(predicates.toArray(new Predicate[]{}));
        return entityManager.createQuery(cq).getResultList();
    }

}
