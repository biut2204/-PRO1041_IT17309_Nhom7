/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.NhaTro;
import Repo.NhaTroRepo;
import Service.IsvNhaTroImpl;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public class NhaTroImpl implements IsvNhaTroImpl{
    private NhaTroRepo ntR = new NhaTroRepo();
    
    @Override
    public List<NhaTro> getAllData() {
        return ntR.getAllData();
    }
    
    @Override
    public void save(NhaTro nhaTro) {
        ntR.save(nhaTro);
    }
    
    @Override
    public void update(NhaTro nhaTro) {
        ntR.update(nhaTro);
    }
    
    @Override
    public UUID findByIdCN(String ten) {
        return ntR.findByIdCN(ten);
    }

    @Override
    public Long DemPhong() {
        return ntR.DemPhong();
    }

    @Override
    public Long DemDichVu() {
        return ntR.DemDichVu();
    }
}
