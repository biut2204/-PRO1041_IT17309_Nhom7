/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.TaiKhoan;
import Repo.TaiKhoanRepo;
import Service.IsvTaiKhoanImpl;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public class TaiKhoanImpl implements IsvTaiKhoanImpl{
    private TaiKhoanRepo tkR = new TaiKhoanRepo();
    
    @Override
    public List<TaiKhoan> getAllData() {
        return tkR.getAllData();
    }

    @Override
    public String findById(String tenTaiKhoan, String matKhau) {
        return tkR.findById(tenTaiKhoan, matKhau);
    }
    
    @Override
    public UUID findByTen(String hoTen) {
        return tkR.findByTen(hoTen);
    }
    
    @Override
    public String findByIdNguoiThue(String tenTaiKhoan, String matKhau) {
        return tkR.findByIdNguoiThue(tenTaiKhoan, matKhau);
    }
    
    @Override
    public String check(String tenTaiKhoan) {
        return tkR.check(tenTaiKhoan);
    }
    
    @Override
    public void save(TaiKhoan tk) {
        tkR.save(tk);
    }
    
    @Override
    public void update(TaiKhoan tk) {
        tkR.update(tk);
    }
}
