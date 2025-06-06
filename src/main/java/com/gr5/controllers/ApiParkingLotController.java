/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.controllers;

import com.gr5.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luann
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;
    
   @DeleteMapping("/{parkingLotId}") 
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void destroy(@PathVariable(value = "parkingLotId") Long id) {
       this.parkingLotService.deleleParkingLot(id);
   }
    
}
