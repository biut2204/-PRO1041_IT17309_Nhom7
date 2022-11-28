/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Models.TienPhong;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public interface IsvTienPhongImpl {
    public List<TienPhong> getAllData();
    
    public UUID findByIdPhong(String ten);
    
    public UUID findByIdTienPhong(String ten);
    
    public Long findTienPhong(String ten);
    
    public Long DemTienPhong();
    
    public Long TongDichVu(String ten);
    
    public Long Dien(String ten);
    
    public Long Nuoc(String ten);
    
    public String findTenPhong(String ten);
    
    public void save(TienPhong tienPhong);

    public void update(TienPhong tienPhong);
    
    public int checkTienThang(String ten,int ngayTao);

}
