/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author MSI
 */
@Entity
@Table(name = "ChiTietTienPhong")
public class ChiTietTienPhong {
    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "TienPhongID",referencedColumnName = "Id")
    private TienPhong tienPhong;
    
    @Column(name = "DichVu")
    private int dichVu;

    public ChiTietTienPhong() {
        
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TienPhong getTienPhong() {
        return tienPhong;
    }

    public void setTienPhong(TienPhong tienPhong) {
        this.tienPhong = tienPhong;
    }

    public int getDichVu() {
        return dichVu;
    }

    public void setDichVu(int dichVu) {
        this.dichVu = dichVu;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getBangKeDien() {
        return bangKeDien;
    }

    public void setBangKeDien(int bangKeDien) {
        this.bangKeDien = bangKeDien;
    }

    public int getBangKeNuoc() {
        return bangKeNuoc;
    }

    public void setBangKeNuoc(int bangKeNuoc) {
        this.bangKeNuoc = bangKeNuoc;
    }

    public int getDonGiaDien() {
        return donGiaDien;
    }

    public void setDonGiaDien(int donGiaDien) {
        this.donGiaDien = donGiaDien;
    }

    public int getDonGiaNuoc() {
        return donGiaNuoc;
    }

    public void setDonGiaNuoc(int donGiaNuoc) {
        this.donGiaNuoc = donGiaNuoc;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public ChiTietTienPhong(UUID id, TienPhong tienPhong, int dichVu, String ma, int bangKeDien, int bangKeNuoc, int donGiaDien, int donGiaNuoc, Date thoiGianBatDau, Date thoiGianKetThuc, int donGia) {
        this.id = id;
        this.tienPhong = tienPhong;
        this.dichVu = dichVu;
        this.ma = ma;
        this.bangKeDien = bangKeDien;
        this.bangKeNuoc = bangKeNuoc;
        this.donGiaDien = donGiaDien;
        this.donGiaNuoc = donGiaNuoc;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.donGia = donGia;
    }
    
    @Column(name ="Ma")
    private String ma;
    
    @Column(name ="bangKeDien")
    private int bangKeDien;
    
    @Column(name ="BangKeNuoc")
    private int bangKeNuoc;
    
    @Column(name ="DonGiaDien")
    private int donGiaDien;
    
    @Column(name ="DonGiaNuoc")
    private int donGiaNuoc;
    
    @Column(name ="ThoiGianBatDau")
    private Date thoiGianBatDau;
    
    @Column(name ="ThoaiGianKetThuc")
    private Date thoiGianKetThuc;
    
    @Column(name ="DonGia")
    private int donGia;
}
