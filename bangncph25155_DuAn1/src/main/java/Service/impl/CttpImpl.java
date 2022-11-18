/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.ChiTietTienPhong;
import Repo.CttpRepo;
import Service.IsvCttpImpl;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public class CttpImpl implements IsvCttpImpl{
    private CttpRepo cttpR = new CttpRepo();
    
    @Override
    public List<ChiTietTienPhong> getAllData() {
        return cttpR.getAllData();
    }
    
    @Override
    public void save(ChiTietTienPhong cttp) {
        cttpR.save(cttp);
    }
    
    @Override
    public void update(ChiTietTienPhong cttp) {
        cttpR.update(cttp);
    }
    
    @Override
    public UUID findByIdTienPhong(String ten) {
        return cttpR.findByIdTienPhong(ten);
    }
}
