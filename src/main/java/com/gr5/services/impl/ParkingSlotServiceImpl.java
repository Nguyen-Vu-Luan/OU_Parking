/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.services.impl;

import com.cloudinary.Cloudinary;
import com.gr5.pojo.ParkingSlots;
import com.gr5.repositories.ParkingSlotRepository;
import com.gr5.services.ParkingSlotService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.cloudinary.utils.ObjectUtils;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.Level;

/**
 *
 * @author luann
 */
@Service
public class ParkingSlotServiceImpl implements ParkingSlotService{
    @Autowired
    private ParkingSlotRepository slotRepo;

    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<ParkingSlots> getAllSlots() {
        return this.slotRepo.getAllSlots();
    }   

    @Override
    public List<ParkingSlots> getSlotByLotID(Long parkingLotId) {
        return this.slotRepo.getSlotByLotID(parkingLotId);
    }

    @Override
    public ParkingSlots addOrUpdateParkingSlot(ParkingSlots p) {
        if (!p.getFile().isEmpty()) {
            try {
                Map res = cloudinary.uploader().upload(p.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                p.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(ParkingLotServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        p.setImage("");
        return this.slotRepo.addOrUpdateParkingSlot(p);
    }

    @Override
    public ParkingSlots getParkingSlotById(Long id) {
        return this.slotRepo.getParkingSlotById(id);
    }

    @Override
    public void deleleParkingSlot(Long id) {
        this.slotRepo.deleleParkingSlot(id);
    }
    
}
