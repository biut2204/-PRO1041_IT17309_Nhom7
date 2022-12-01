/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Models.TienPhong;
import Repo.TienPhongRepo;
import Service.IsvTienPhongImpl;
import java.util.Date;
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
    public UUID findByIdTienPhong(String ten) {
        return tpR.findByIdTienPhong(ten);
    }
    
    @Override
    public Long findTienPhong(String ten) {
        return tpR.findTienPhong(ten);
    }
    
    @Override
    public String findTenPhong(String ten) {
        return tpR.findTenPhong(ten);
    }
    
    @Override
    public void update(TienPhong tienPhong) {
        tpR.update(tienPhong);
    }

    @Override
    public int checkTienThang(String ten, int ngayTao) {
        return tpR.checkTienThang(ten, ngayTao);
    }

    @Override
    public Long DemTienPhong() {
       return tpR.DemTienPhong();
    }

    @Override
    public Long TongDichVu(String ten) {
        return tpR.TongDichVu(ten);
    }

    @Override
    public Long Dien(String ten) {
        return tpR.Dien(ten);
    }

    @Override
    public Long Nuoc(String ten) {
        return tpR.Nuoc(ten);
    }

    @Override
    public UUID findByIdChiTietTienPhong(String ten) {
        return tpR.findByIdChiTietTienPhong(ten);
    }

    @Override
    public Long ThongKe(String trangThai, int thang, int nam) {
        return  tpR.ThongKe(trangThai, thang, nam);
    }

    @Override
    public Long ThongKeTong(int thang, int nam) {
        return tpR.ThongKeTong(thang, nam);
    }

    @Override
    public Long ThongKeTheoNam(String trangThai, int nam) {
        return tpR.ThongKeTheoNam(trangThai, nam);
    }

    @Override
    public Long ThongKeTheoNamTong(int nam) {
        return tpR.ThongKeTheoNamTong(nam);
    }











    



   
}
