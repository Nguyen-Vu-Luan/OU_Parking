/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.repositories;

import com.gr5.pojo.ParkingSlots;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luann
 */
public interface ParkingSlotRepository {
    List<ParkingSlots> getSlots(Map<String, String> params);
}
