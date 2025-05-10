/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.repositories;

import com.gr5.pojo.ParkingLots;
import java.util.List;

/**
 *
 * @author luann
 */
public interface ParkingLotRepository {
    List<ParkingLots> getLots();
    List<ParkingLots> findParkingLotsByKeyWord(String kw);
//    ParkingLots getParkingLotById(int id);
//    ParkingLots addOrUpdateParkingLot(ParkingLots p);
//    void deleleParkingLot(int id);
}
