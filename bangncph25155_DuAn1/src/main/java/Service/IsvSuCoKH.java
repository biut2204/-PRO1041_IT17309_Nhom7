/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Models.SuCoKH;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Thanh Giang
 */
public interface IsvSuCoKH {

    public List<SuCoKH> getAllData();

    public void save(SuCoKH sckh);

    public void update(SuCoKH sckh);
    
    public UUID findByIdPhong(String ten);
}
