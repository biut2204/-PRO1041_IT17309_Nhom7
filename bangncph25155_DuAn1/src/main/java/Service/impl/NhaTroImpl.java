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
    private NhaTroRepo pR = new NhaTroRepo();
    
    @Override
    public List<NhaTro> getAllData() {
        return pR.getAllData();
    }
    
    @Override
    public void save(NhaTro nhaTro) {
        pR.save(nhaTro);
    }
    
    @Override
    public void update(NhaTro nhaTro) {
        pR.update(nhaTro);
    }
    
    @Override
    public UUID findByIdCN(String ten) {
        return pR.findByIdCN(ten);
    }
}
