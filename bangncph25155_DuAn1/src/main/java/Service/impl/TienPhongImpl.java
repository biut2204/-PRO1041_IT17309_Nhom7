/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.TienPhong;
import Repo.TienPhongRepo;
import Service.IsvTienPhongImpl;
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
    public Integer findTienPhong(String ten) {
        return tpR.findTienPhong(ten);
    }
    
    @Override
    public void update(TienPhong tienPhong) {
        tpR.update(tienPhong);
    }
   
}
