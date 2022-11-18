/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.DichVu;
import Repo.DichVuRepo;
import Service.IsvDichVuImpl;
import java.util.List;

/**
 *
 * @author MSI
 */
public class DichVuImpl implements IsvDichVuImpl{
     private DichVuRepo dvR = new DichVuRepo();
    
    @Override
    public List<DichVu> getAllData() {
        return dvR.getAllData();
    }
    
    @Override
    public void save(DichVu dichVu) {
        dvR.save(dichVu);
    }
    
    @Override
    public void update(DichVu dichVu) {
        dvR.update(dichVu);
    }
}
