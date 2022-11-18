/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.NguoiThue;
import Repo.NguoiThueRepo;
import Repo.TaiKhoanRepo;
import java.util.UUID;
import Service.IsvNguoiThueImpl;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MSI
 */
public class NguoiThueImpl implements IsvNguoiThueImpl{
    private NguoiThueRepo ntR = new NguoiThueRepo();
    
    @Override
    public String findHoTen(String id) {        
        return ntR.findHoTen(id);
    }

    @Override
    public Date findNgaySinh(String id) {
        return ntR.findNgaySinh(id);
    }

    @Override
    public String findGioiTinh(String id) {
        return ntR.findGioiTinh(id);
    }

    @Override
    public String findSdt(String id) {
        return ntR.findSdt(id);
    }

    @Override
    public String findDiaChi(String id) {
        return ntR.findDiaChi(id);
    }

    @Override
    public String findDiXe(String id) {
        return ntR.findDiXe(id);
    }

    @Override
    public String findTrangThai(String id) {
        return ntR.findTrangThai(id);
    }
    
    @Override
    public void save(NguoiThue nt) {
        ntR.save(nt);
    }
    
    @Override
    public List<NguoiThue> getAllData() {
        return ntR.getAlldata();
    }
    
    @Override
    public void update(NguoiThue nt) {
        ntR.update(nt);
    }
}
