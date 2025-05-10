/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.controllers;

import com.gr5.pojo.ParkingLots;
import com.gr5.services.ParkingLotService;
import java.util.List;
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
    public String index(@RequestParam(value = "kw", required = false) String kw, Model model) {
        List<ParkingLots> parkingLots;

        if (kw != null) { // Kiểm tra nếu người dùng đã nhấn tìm kiếm
            if (kw.trim().isEmpty()) {
                model.addAttribute("message", "Vui lòng nhập từ khóa tìm kiếm!");
                parkingLots = parkingLotService.getLots(); // Hiển thị danh sách đầy đủ
            } else {
                parkingLots = parkingLotService.findParkingLotsByKeyWord(kw);
                if (parkingLots.isEmpty()) {
                    model.addAttribute("message", "Không có bãi đỗ nào phù hợp!");
                }
            }
        } else {
            parkingLots = parkingLotService.getLots();
        }

        model.addAttribute("ParkingLots", parkingLots);
        return "index";
    }
}
