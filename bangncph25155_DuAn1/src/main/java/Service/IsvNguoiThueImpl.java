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
    
    public String findSdt(String id);
    
    public String findDiaChi(String id);
    
    public String findDiXe(String id);
    
    public String findTrangThai(String id);
    
    public List<NguoiThue> getAllData();

    public void save(NguoiThue nt);
    
    public void update(NguoiThue nt);
}
