/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.controllers;

import com.gr5.services.ParkingSlotService;
import com.gr5.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import com.gr5.pojo.ParkingSlots;
import com.gr5.pojo.ParkingLots;
import java.util.List;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;

/**
 *
 * @author luann
 */
@Controller
@ControllerAdvice
public class SlotController {

    @Autowired
    private ParkingSlotService parkingSlotService;

    @Autowired
    private ParkingLotService parkingLotService;

    @RequestMapping("/slot")
    public String getAllSlots(@RequestParam(required = false) Long parkinglotId,
            Model model) {
        // Load danh sách tất cả bãi đỗ (dropdown)
        List<ParkingLots> parkingLots = parkingLotService.getLots();
        model.addAttribute("ParkingLots", parkingLots);

        // Khởi tạo danh sách chỗ đỗ
        List<ParkingSlots> parkingSlots = new ArrayList<>();
        String selectedLotName = " --Tất cả bãi đỗ-- ";

        // Xử lý trường hợp không chọn bãi đỗ (mặc định = 0 hoặc null)
        if (parkinglotId == null || parkinglotId == 0) {
            parkingSlots = parkingSlotService.getAllSlots();
        } else {
            // Lấy danh sách chỗ đỗ theo bãi đỗ đã chọn
            parkingSlots = parkingSlotService.getSlotByLotID(parkinglotId);
            ParkingLots selectedLot = parkingLotService.getParkingLotById(parkinglotId);
            if (selectedLot != null) {
                selectedLotName = selectedLot.getName();
            }
        }

        // Gửi dữ liệu cho view
        model.addAttribute("ParkingSlots", parkingSlots);
        model.addAttribute("selectedLotId", parkinglotId);
        model.addAttribute("selectedLotName", selectedLotName);
        return "slot";
    }    
}