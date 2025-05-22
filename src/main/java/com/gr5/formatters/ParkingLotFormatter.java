/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.formatters;

import org.springframework.format.Formatter;
import com.gr5.pojo.ParkingLots;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author luann
 */
public class ParkingLotFormatter implements Formatter<ParkingLots>{

    @Override
    public String print(ParkingLots pl, Locale locale) {
        return String.valueOf(pl.getId());
    }

    @Override
    public ParkingLots parse(String lotId, Locale locale) throws ParseException {
        ParkingLots pl = new ParkingLots();
        pl.setId(Integer.parseInt(lotId));
        return pl;
    }    
}
