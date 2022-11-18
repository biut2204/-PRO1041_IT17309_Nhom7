/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.Phong;
import Repo.PhongRepo;
import Service.IsvPhongImpl;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public class PhongImpl implements IsvPhongImpl{
    
    private PhongRepo pR = new PhongRepo();
    
    @Override
    public List<Phong> getAllData() {
        return pR.getAllData();
    }
    
    @Override
    public void save(Phong phong) {
        pR.save(phong);
    }

    @Override
    public UUID findByIdNT(String ten) {
        return pR.findByIdNT(ten);
    }
    
    @Override
    public UUID findByIdNhaTro(String ten) {
        return pR.findByIdNhaTro(ten);
    }
    
    @Override
    public Long findSoNguoiHienCo(String ten) {
        return pR.findSoNguoiHienCo(ten);
    }
    
    @Override
    public Long findSoXeHienCo(String ten, String xe) {
        return pR.findXeHienCo(ten, xe);
    }
    
    @Override
    public void update(Phong phong) {
        pR.update(phong);
    }
}
