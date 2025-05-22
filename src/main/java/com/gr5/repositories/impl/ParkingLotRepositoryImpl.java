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
import java.util.List;
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

//    private static final int PAGE_SIZE = 6;
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<ParkingLots> getLots() {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM ParkingLots", ParkingLots.class);
        return query.getResultList();
    }

    @Override
    public List<ParkingLots> findParkingLotsByKeyWord(String kw) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ParkingLots> query = builder.createQuery(ParkingLots.class);
        Root<ParkingLots> root = query.from(ParkingLots.class);

        query.select(root);

        if (kw != null && !kw.trim().isEmpty()) {
            Predicate predicate = builder.like(builder.lower(root.get("name")), "%" + kw.trim().toLowerCase() + "%");
            query.where(predicate);
        }

        return session.createQuery(query).getResultList();
    }

    @Override
    public ParkingLots getParkingLotById(Long id) {
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
    public void deleleParkingLot(Long id) {
        Session s = this.factory.getObject().getCurrentSession();
        ParkingLots p = this.getParkingLotById(id);
        s.remove(p);
    }
}
