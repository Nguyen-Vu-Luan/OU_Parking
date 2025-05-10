/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.services.impl;

import com.gr5.pojo.ParkingSlots;
import com.gr5.repositories.ParkingSlotRepository;
import com.gr5.services.ParkingSlotService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luann
 */
@Service
public class ParkingSlotServiceImpl implements ParkingSlotService{
    @Autowired
    private ParkingSlotRepository slotRepo;

    @Override
    public List<ParkingSlots> getAllSlots() {
        return this.slotRepo.getAllSlots();
    }   

    @Override
    public List<ParkingSlots> getSlotsByLot(Long lotId) {
        return this.slotRepo.getSlotsByLot(lotId);
    }
}
