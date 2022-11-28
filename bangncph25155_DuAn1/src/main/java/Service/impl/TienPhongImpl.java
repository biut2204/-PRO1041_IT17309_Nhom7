/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.TienPhong;
import Repo.TienPhongRepo;
import Service.IsvTienPhongImpl;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public class TienPhongImpl implements IsvTienPhongImpl{
    private TienPhongRepo tpR = new TienPhongRepo();
    
    @Override
    public List<TienPhong> getAllData() {
        return tpR.getAllData();
    }
    
    @Override
    public void save(TienPhong tienPhong) {
        tpR.save(tienPhong);
    }

    @Override
    public UUID findByIdPhong(String ten) {
        return tpR.findByIdPhong(ten);
    }
    
    @Override
    public UUID findByIdTienPhong(String ten) {
        return tpR.findByIdTienPhong(ten);
    }
    
    @Override
    public Long findTienPhong(String ten) {
        return tpR.findTienPhong(ten);
    }
    
    @Override
    public String findTenPhong(String ten) {
        return tpR.findTenPhong(ten);
    }
    
    @Override
    public void update(TienPhong tienPhong) {
        tpR.update(tienPhong);
    }

    @Override
    public int checkTienThang(String ten, int ngayTao) {
        return tpR.checkTienThang(ten, ngayTao);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }











    



   
}
