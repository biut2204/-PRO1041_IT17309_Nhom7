/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.HopDong;
import Repo.HopDongRepo;
import Service.IsvHopDongImpl;
import java.util.List;

/**
 *
 * @author MSI
 */
public class HopDongImpl implements IsvHopDongImpl{
    private HopDongRepo hdR = new HopDongRepo();
    
    @Override
    public List<HopDong> getAllData() {
        return hdR.getAllData();
    }
    
    @Override
    public void save(HopDong hd) {
        hdR.save(hd);
    }
    
    @Override
    public void update(HopDong hd) {
        hdR.update(hd);
    }
}
