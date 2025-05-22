/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.repositories.impl;

import com.gr5.pojo.ParkingSlots;
import com.gr5.repositories.ParkingSlotRepository;
import jakarta.persistence.Query;
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
public class ParkingSlotRepositoryImpl implements ParkingSlotRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<ParkingSlots> getAllSlots() {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM ParkingSlots", ParkingSlots.class);
        return query.getResultList();
    }

    @Override
    public List<ParkingSlots> getSlotByLotID(Long parkinglotId){
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM ParkingSlots WHERE lotId.id = :parkinglotId", ParkingSlots.class);
        query.setParameter("parkinglotId", parkinglotId);
        return query.getResultList();
    }
    
    @Override
    public ParkingSlots addOrUpdateParkingSlot(ParkingSlots p) {
        Session s = this.factory.getObject().getCurrentSession();
        if (p.getId() == null) {
            s.persist(p);
        } else {
            s.merge(p);
        }

        return p;
    }
    
    @Override
    public ParkingSlots getParkingSlotById(Long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(ParkingSlots.class, id);

    }
    
    @Override
    public void deleleParkingSlot(Long id) {
        Session s = this.factory.getObject().getCurrentSession();
        ParkingSlots p = this.getParkingSlotById(id);
        s.remove(p);
    }
}
