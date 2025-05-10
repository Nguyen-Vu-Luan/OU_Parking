/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.services;

import com.gr5.pojo.ParkingLots;
import java.util.List;

/**
 *
 * @author luann
 */

public interface ParkingLotService {
    List<ParkingLots> getLots();
    List<ParkingLots> findParkingLotsByKeyWord(String kw);
}
