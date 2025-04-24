/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.repositories.impl;

import com.gr5.pojo.ParkingLots;
import com.gr5.repositories.ParkingLotRepository;
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
public class ParkingLotRepositoryImpl implements ParkingLotRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<ParkingLots> getLots() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM ParkingLots", ParkingLots.class);
        return q.getResultList();
    }
}
