/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service.impl;

import com.njt.entity.Korisnik;
import com.njt.repository.KorisnikRepository;
import com.njt.service.KorisnikService;
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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Roki
 */
@Service
@Transactional
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    KorisnikRepository korisnikRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }

    @Override
    public Korisnik findById(int id) {
        Optional<Korisnik> korisnik = korisnikRepository.findById(id);

        if (korisnik.isPresent()) {
            return korisnik.get();
        }

        throw new EntityNotFoundException("Korisnik ne postoji!");
    }

    @Override
    public void saveOrUpdate(Korisnik korisnik) {
        korisnikRepository.saveAndFlush(korisnik);
    }

    @Override
    public List<Korisnik> search(int id, String imePrezime, String radnik) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<Korisnik> korisnik = cq.from(Korisnik.class);

        List<Predicate> predicates = new ArrayList<>();

        if (id != 0) {
            List<Korisnik> korisnici = new ArrayList<>();
            korisnici.add(findById(id));
            return korisnici;
        }
        if (imePrezime != null) {
            predicates.add(qb.like(korisnik.get("imePrezime"), imePrezime + "%"));
        }
        if (radnik != null) {
            predicates.add(qb.like(korisnik.get("radnik").get("imePrezime"), radnik + "%"));
        }

        cq.select(korisnik).where(predicates.toArray(new Predicate[]{}));
        return entityManager.createQuery(cq).getResultList();
    }

}
