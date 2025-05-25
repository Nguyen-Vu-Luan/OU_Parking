/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.services;

import com.gr5.pojo.ParkingLots;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luann
 */

public interface ParkingLotService {
    List<ParkingLots> getLots();
    List<ParkingLots> findParkingLotsByKeyWord(Map<String, String> params);
    ParkingLots addOrUpdateParkingLot(ParkingLots p);
    ParkingLots getParkingLotById(Long id);
    void deleleParkingLot(Long id);
}
