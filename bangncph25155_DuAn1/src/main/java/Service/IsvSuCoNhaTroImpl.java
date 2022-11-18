/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Models.SuCoNhaTro;
import java.util.List;

/**
 *
 * @author MSI
 */
public interface IsvSuCoNhaTroImpl {
    
    public List<SuCoNhaTro> getAllData();
    
    public void save(SuCoNhaTro scnt);

    public void update(SuCoNhaTro scnt);

}
