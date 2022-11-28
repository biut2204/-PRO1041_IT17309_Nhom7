/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Models.DichVuPhong;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public interface IsvDichVuPhongImpl {
    public List<DichVuPhong> getAllData();
    
    public void save(DichVuPhong dichVu);

    public void update(DichVuPhong dichVu);
    
    public UUID findByIdDichVu(String ten);
    
    public Long DemDichVuPhong();
}
