/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Models.DichVu;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public interface IsvDichVuImpl {
    public List<DichVu> getAllData();
    
    public void save(DichVu dichVu);

    public void update(DichVu dichVu);
}
