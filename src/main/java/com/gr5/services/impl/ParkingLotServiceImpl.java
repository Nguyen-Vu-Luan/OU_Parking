/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.services.impl;

import com.gr5.pojo.ParkingLots;
import com.gr5.repositories.ParkingLotRepository;
import com.gr5.services.ParkingLotService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luann
 */
@Service
public class ParkingLotServiceImpl implements ParkingLotService{
    @Autowired
    private ParkingLotRepository lotRepo;

    @Override
    public List<ParkingLots> getLots() {
        return this.lotRepo.getLots();
    }
}
