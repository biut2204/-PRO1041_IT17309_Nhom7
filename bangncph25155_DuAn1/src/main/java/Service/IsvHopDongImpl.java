/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Models.HopDong;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public interface IsvHopDongImpl {
    public List<HopDong> getAllData();
    
    public void save(HopDong hd);

    public void update(HopDong hd);
}
