/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Models.Phong;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public interface IsvPhongImpl {
    public List<Phong> getAllData();

    public UUID findByIdNT(String ten);
    
    public UUID findByIdNhaTro(String ten);
    
    public Long findSoNguoiHienCo(String ten);
    
    public Long findSoXeHienCo(String ten, String xe);
    
    public void save(Phong phong);

    public void update(Phong phong);
}
