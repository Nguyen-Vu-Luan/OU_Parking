/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.services.impl;

import com.cloudinary.Cloudinary;
import com.gr5.pojo.ParkingLots;
import com.gr5.repositories.ParkingLotRepository;
import com.gr5.services.ParkingLotService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;
/**
 *
 * @author luann
 */
@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    private ParkingLotRepository lotRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<ParkingLots> getLots() {
        return this.lotRepo.getLots();
    }

    @Override
    public List<ParkingLots> findParkingLotsByKeyWord(Map<String, String> params) {
        return this.lotRepo.findParkingLotsByKeyWord(params);
    }
    
    @Override
    public ParkingLots getParkingLotById(Long id) {
        return this.lotRepo.getParkingLotById(id);
    }

    @Override
    public void deleleParkingLot(Long id) {
        this.lotRepo.deleleParkingLot(id);
    }

    @Override
    public ParkingLots addOrUpdateParkingLot(ParkingLots p) {
        if (!p.getFile().isEmpty() && p.getFile() != null) {
            try {
                Map res = cloudinary.uploader().upload(p.getFile().getBytes(),
                        ObjectUtils.asMap("recource_type", "auto"));
                p.setImage((String) res.get("secure_url"));
            } catch (IOException ex) {
                Logger.getLogger(ParkingLotServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        p.setImage("https://res.cloudinary.com/dgosettle/image/upload/v1748183273/b%C3%A3i_%C4%91%E1%BB%97_xe_in_Long_Thanh_My_Ward_HCMC_Vietnam_cxqtrs.png");
        return this.lotRepo.addOrUpdateParkingLot(p);
    }
} 
