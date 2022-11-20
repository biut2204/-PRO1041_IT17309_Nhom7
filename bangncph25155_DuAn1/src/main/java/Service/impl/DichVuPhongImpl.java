/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.DichVuPhong;
import Repo.DichVuPhongRepo;
import Service.IsvDichVuPhongImpl;
import java.util.List;

/**
 *
 * @author MSI
 */
public class DichVuPhongImpl implements IsvDichVuPhongImpl{
     private DichVuPhongRepo dvR = new DichVuPhongRepo();
    
    @Override
    public List<DichVuPhong> getAllData() {
        return dvR.getAllData();
    }
    
    @Override
    public void save(DichVuPhong dichVu) {
        dvR.save(dichVu);
    }
    
    @Override
    public void update(DichVuPhong dichVu) {
        dvR.update(dichVu);
    }
}
