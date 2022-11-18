/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Models.NhaTro;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public interface IsvNhaTroImpl {
    public List<NhaTro> getAllData();

    public UUID findByIdCN(String ten);
    
    public void save(NhaTro nhaTro);

    public void update(NhaTro nhaTro);
}
