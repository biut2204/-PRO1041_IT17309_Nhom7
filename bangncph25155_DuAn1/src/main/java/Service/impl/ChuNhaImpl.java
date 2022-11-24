/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Repo.ChuNhaRepo;
import Service.IsvChuNhaImpl;

/**
 *
 * @author MSI
 */
public class ChuNhaImpl implements IsvChuNhaImpl{

    private ChuNhaRepo tkR = new ChuNhaRepo();

    @Override
    public Long findSuCoNT(String tenTaiKhoan) {
        return tkR.findSuCoNT(tenTaiKhoan);
    }
}
