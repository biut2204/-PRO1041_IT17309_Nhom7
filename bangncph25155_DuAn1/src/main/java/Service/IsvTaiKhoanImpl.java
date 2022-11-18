/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Models.TaiKhoan;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author MSI
 */
public interface IsvTaiKhoanImpl {

    public String findById(String tenTaiKhoan, String matKhau);

    public UUID findByTen(String hoTen);

    public String findByIdNguoiThue(String tenTaiKhoan, String matKhau);

    public String check(String tenTaiKhoan);

    public List<TaiKhoan> getAllData();

    public void save(TaiKhoan tk);
    
    public void update(TaiKhoan tk);
}
