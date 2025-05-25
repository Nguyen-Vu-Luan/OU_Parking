/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.controllers;

import com.gr5.services.ParkingLotService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author luann
 */
@Controller
@ControllerAdvice
public class IndexController {

    @Autowired
    private ParkingLotService parkingLotService;

    @ModelAttribute
    public void commonResponse(Model model) {
        model.addAttribute("ParkingLots", this.parkingLotService.getLots());
    }

    @RequestMapping("/")
    public String index(@RequestParam Map<String, String> params, Model model) {
        model.addAttribute("ParkingLots", this.parkingLotService.findParkingLotsByKeyWord(params));
        return "index";
    }
}
