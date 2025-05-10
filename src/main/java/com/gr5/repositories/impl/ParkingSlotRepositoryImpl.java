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
    public List<ParkingSlots> getSlotsByLot(Long lotId) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM ParkingSlots ps JOIN FETCH ps.lot WHERE ps.lot.id = :lotId", ParkingSlots.class);
        query.setParameter("lotId", lotId);
        return query.getResultList();
    }

//    public List<ParkingSlots> getSlotByLotID(Long lotId){
//        Session s = this.factory.getObject().getCurrentSession();
//        Query query = s.createQuery("FROM ParkingSlots WHERE lotId = :lotId", ParkingSlots.class);
//        query.setParameter("lotId", lotId);
//        return query.getResultList();
//    }
//    public void addSlot(ParkingSlots slot){
//        Session s = this.factory.getObject().getCurrentSession();
//        Transaction tx = s.beginTransaction();
//        s.save(slot);
//        tx.commit();
//    }
}
