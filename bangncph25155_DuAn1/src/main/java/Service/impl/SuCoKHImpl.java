/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.SuCoKH;
import Repo.SuCoKHRepo;
import Service.IsvSuCoKH;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Thanh Giang
 */
public class SuCoKHImpl implements IsvSuCoKH{
    private SuCoKHRepo sckhR = new SuCoKHRepo();

    @Override
    public List<SuCoKH> getAllData() {
        return sckhR.getAllData();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    @Override
    public UUID findByIdPhong(String ten) {
        return sckhR.findByIdPhong(ten);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(SuCoKH sckh) {
        sckhR.save(sckh);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(SuCoKH sckh) {
        sckhR.update(sckh);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    
}
