/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.formatters;

import com.gr5.pojo.ParkingSlots;
import org.springframework.format.Formatter;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author luann
 */
public class ParkingSlotFormatter implements Formatter<ParkingSlots>{
    @Override
    public String print(ParkingSlots pl, Locale locale) {
        return String.valueOf(pl.getId());
    }

    @Override
    public ParkingSlots parse(String lotId, Locale locale) throws ParseException {
        ParkingSlots pl = new ParkingSlots();
        pl.setId(Integer.parseInt(lotId));
        return pl;
    }    
}
