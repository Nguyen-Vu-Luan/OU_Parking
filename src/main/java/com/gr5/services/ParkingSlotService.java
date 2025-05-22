/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.services;

import com.gr5.pojo.ParkingSlots;
import java.util.List;

/**
 *
 * @author luann
 */
public interface ParkingSlotService {
    List<ParkingSlots> getAllSlots();
    List<ParkingSlots> getSlotByLotID(Long parkingLotId);
    ParkingSlots addOrUpdateParkingSlot(ParkingSlots p);
    ParkingSlots getParkingSlotById(Long id);
    void deleleParkingSlot(Long id);
}
