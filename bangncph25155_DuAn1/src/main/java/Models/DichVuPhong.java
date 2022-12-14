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
@Table(name = "DichVuPhong")
public class DichVuPhong {
    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "PhongID")
    private Phong phong;
    
    @ManyToOne
    @JoinColumn(name = "DichVuID")
    private DichVu dichVu;
    
    @Column(name ="Ma")
    private String ma;
    
    @Column(name ="DonGia")
    private int donGia;
    
    @Column(name ="NgayBatdau")
    private Date ngayBatdau;
    
    @Column(name ="NgayHetHan")
    private Date ngayHetHan;
    
    @Column(name ="TrangThai")
    private String trangThai;
    
    public DichVuPhong(){
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public Date getNgayBatdau() {
        return ngayBatdau;
    }

    public void setNgayBatdau(Date ngayBatdau) {
        this.ngayBatdau = ngayBatdau;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public DichVuPhong(UUID id, Phong phong, DichVu dichVu, String ma, int donGia, Date ngayBatdau, Date ngayHetHan, String trangThai) {
        this.id = id;
        this.phong = phong;
        this.dichVu = dichVu;
        this.ma = ma;
        this.donGia = donGia;
        this.ngayBatdau = ngayBatdau;
        this.ngayHetHan = ngayHetHan;
        this.trangThai = trangThai;
    }
}
