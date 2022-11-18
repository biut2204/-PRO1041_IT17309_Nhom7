/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Models.ChiTietTienPhong;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public interface IsvCttpImpl {
    public List<ChiTietTienPhong> getAllData();
    
    public void save(ChiTietTienPhong cttp);

    public void update(ChiTietTienPhong cttp);
    
    public UUID findByIdTienPhong(String ten);
}
