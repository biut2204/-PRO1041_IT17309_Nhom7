/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Models.NguoiThue;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public interface IsvNguoiThueImpl {
    public String findHoTen(String id);
    
    public Date findNgaySinh(String id);
    
    public String findGioiTinh(String id);
    
    public Long findSo();
    
    public String findSdt(String id);
    
    public String findDiaChi(String id);
    
    public String findDiXe(String id);
    
    public String findTrangThai(String id);
    
    public List<NguoiThue> getAllData();

    public void save(NguoiThue nt);
    
    public void update(NguoiThue nt);
    
    public String findMK(String id);
    
    public UUID findidTK(String id);
    
    public UUID findidNguoiThue(String id);
    
    public String findVaiTro(String id);
    
    public String findTenTK(String id);
    
    public String checkHoTen(String id);
}
