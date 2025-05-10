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
    public List<ParkingSlots> getSlotsByLot(Long lotId);
}
