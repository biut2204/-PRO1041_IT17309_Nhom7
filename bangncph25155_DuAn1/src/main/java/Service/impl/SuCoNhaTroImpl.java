/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.SuCoNhaTro;
import Repo.SuCoNhaTroRepo;
import Service.IsvSuCoNhaTroImpl;
import java.util.List;

/**
 *
 * @author MSI
 */
public class SuCoNhaTroImpl implements IsvSuCoNhaTroImpl{
    private SuCoNhaTroRepo scntR = new SuCoNhaTroRepo();
    
    @Override
    public List<SuCoNhaTro> getAllData() {
        return scntR.getAllData();
    }
    
    @Override
    public void save(SuCoNhaTro scnt) {
        scntR.save(scnt);
    }
    
    @Override
    public void update(SuCoNhaTro scnt) {
        scntR.update(scnt);
    }
}
