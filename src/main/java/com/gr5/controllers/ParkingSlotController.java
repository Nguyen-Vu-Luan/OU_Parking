/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.controllers;

import com.gr5.pojo.ParkingSlots;
import com.gr5.services.ParkingLotService;
import com.gr5.services.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author luann
 */
@Controller
public class ParkingSlotController {
    
    @Autowired
    private ParkingLotService parkingLotService;
    
    @Autowired
    private ParkingSlotService parkingSlotService;
    
    @GetMapping("/parkingSlot")
    public String createView(Model model) {
        model.addAttribute("ParkingSlots", new ParkingSlots());
        model.addAttribute("ParkingLots", this.parkingLotService.getLots());
        return "parkingSlot"; 
    }
    
    @GetMapping("/parkingSlot/{parkingSlotId}")
    public String updateView(Model model, @PathVariable(value = "parkingSlotId") Long id) {
        model.addAttribute("ParkingSlots", this.parkingSlotService.getParkingSlotById(id));        
        model.addAttribute("ParkingLots", this.parkingLotService.getLots());
        return "parkingSlot";    
    }
    
    @PostMapping("/addpsl")
    public String add(@ModelAttribute(value = "ParkingSlots") ParkingSlots psl) {
        this.parkingSlotService.addOrUpdateParkingSlot(psl);
        return "redirect:/slot";
    }
}
