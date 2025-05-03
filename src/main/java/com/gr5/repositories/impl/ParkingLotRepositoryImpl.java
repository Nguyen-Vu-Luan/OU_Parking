/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.repositories.impl;

import com.gr5.pojo.ParkingLots;
import com.gr5.repositories.ParkingLotRepository;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luann
 */
@Repository
@Transactional
public class ParkingLotRepositoryImpl implements ParkingLotRepository {

    private static final int PAGE_SIZE = 6;

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<ParkingLots> getLots() {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM ParkingLots", ParkingLots.class);
        return query.getResultList();
    }

    @Override
    public List<ParkingLots> getLots(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<ParkingLots> q = b.createQuery(ParkingLots.class);
        Root root = q.from(ParkingLots.class);
        q.select(root);

        if (params != null) {

            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
            }
        }
        
        Query query = s.createQuery(q);
        
        if (params != null && params.containsKey("page")) {
            int page = Integer.parseInt(params.get("page"));
            int start = (page - 1) * PAGE_SIZE;

            query.setMaxResults(PAGE_SIZE);
            query.setFirstResult(start);
        }
        return query.getResultList();
    }

    @Override
    public ParkingLots getParkingLotById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(ParkingLots.class, id);

    }

    @Override
    public ParkingLots addOrUpdateParkingLot(ParkingLots p) {
        Session s = this.factory.getObject().getCurrentSession();
        if (p.getId() == null) {
            s.persist(p);
        } else {
            s.merge(p);
        }

        return p;

    }

    @Override
    public void deleleParkingLot(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        ParkingLots p = this.getParkingLotById(id);
        s.remove(p);
    }
}
