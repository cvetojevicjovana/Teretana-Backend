/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.service.impl;

import com.njt.entity.Radnik;
import com.njt.repository.RadnikRepository;
import com.njt.service.RadnikService;
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
public class RadnikServiceImpl implements RadnikService {

    @Autowired
    RadnikRepository radnikRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Radnik> findAll() {
        return radnikRepository.findAll();
    }

    @Override
    public Radnik findById(int id) {
        Optional<Radnik> radnik = radnikRepository.findById(id);

        if (radnik.isPresent()) {
            return radnik.get();
        }

        throw new EntityNotFoundException("Radnik ne postoji!");
    }

    @Override
    public Radnik findByUsernameAndPassword(String username, String password) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<Radnik> radnik = cq.from(Radnik.class);

        List<Predicate> predicates = new ArrayList<>();

        if (username != null) {
            predicates.add(qb.equal(radnik.get("username"), username));
        }
        if (password != null) {
            predicates.add(qb.equal(radnik.get("password"), password));
        }

        cq.select(radnik).where(predicates.toArray(new Predicate[]{}));
        return (Radnik) entityManager.createQuery(cq).getResultList().get(0);
    }

    @Override
    public Radnik findByUsernamee(String username) {
        List<Radnik> radniciSvi = findAll();
        for (Radnik radnik : radniciSvi) {
            if (radnik.getUsername().equals(username)) {
                return radnik;
            }
        }
        return null;
    }

}
