/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.controllers;

import com.gr5.services.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author luann
 */
@Controller
public class SlotController {
    @Autowired
    private ParkingSlotService parkingSlotService;
    
    @GetMapping("/slot")
    public String slot(Model model) {
        model.addAttribute("ParkingSlots", this.parkingSlotService.getAllSlots());
        return "slot";
    }
}
