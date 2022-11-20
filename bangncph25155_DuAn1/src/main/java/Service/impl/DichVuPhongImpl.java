/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.DichVuPhong;
import Repo.DichVuPhongRepo;
import Service.IsvDichVuPhongImpl;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public class DichVuPhongImpl implements IsvDichVuPhongImpl{
    private DichVuPhongRepo dvpR = new DichVuPhongRepo();
    
    @Override
    public List<DichVuPhong> getAllData() {
        return dvpR.getAllData();
    }
    
    @Override
    public void save(DichVuPhong dichVu) {
        dvpR.save(dichVu);
    }
    
    @Override
    public void update(DichVuPhong dichVu) {
        dvpR.update(dichVu);
    }

    @Override
    public UUID findByIdDichVu(String ten) {
        return dvpR.findByIdDichVu(ten);
        
    }
    
    
}
