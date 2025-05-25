/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.controllers;

import com.gr5.pojo.ParkingLots;
import com.gr5.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luann
 */
@Controller
public class ParkingLotController {
    
    @Autowired
    private ParkingLotService parkingLotService;
    
    @GetMapping("/parkingLot")
    public String createView(Model model) {
        model.addAttribute("ParkingLots", new ParkingLots());
        return "parkingLot"; 
    }
    
    @GetMapping("/parkingLot/{parkingLotId}")
    public String updateView(Model model, @PathVariable(value = "parkingLotId") Long id) {
        model.addAttribute("ParkingLots", this.parkingLotService.getParkingLotById(id));
        return "parkingLot";
    }
    
    @PostMapping("/addpl")
    public String add(@ModelAttribute ParkingLots pl, @RequestParam("file") MultipartFile file) {
        pl.setFile(file);
        this.parkingLotService.addOrUpdateParkingLot(pl);
        return "redirect:/";
    }
    
    
}
