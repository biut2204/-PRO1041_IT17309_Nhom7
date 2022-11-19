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
@Table(name = "HopDong")
public class HopDong {

    public HopDong(UUID id, ChuNha chuNha, Phong phong, NguoiThue nguoiThue, String ma, int giaPhong, String noiThatPhong, String hienTrang, int soXe, String noiDung, Date ngayBatDau, Date ngayHetHan, Date ngaySua, String trangThai) {
        this.id = id;
        this.chuNha = chuNha;
        this.phong = phong;
        this.nguoiThue = nguoiThue;
        this.ma = ma;
        this.giaPhong = giaPhong;
        this.noiThatPhong = noiThatPhong;
        this.hienTrang = hienTrang;
        this.soXe = soXe;
        this.noiDung = noiDung;
        this.ngayBatDau = ngayBatDau;
        this.ngayHetHan = ngayHetHan;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ChuNha getChuNha() {
        return chuNha;
    }

    public void setChuNha(ChuNha chuNha) {
        this.chuNha = chuNha;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public NguoiThue getNguoiThue() {
        return nguoiThue;
    }

    public void setNguoiThue(NguoiThue nguoiThue) {
        this.nguoiThue = nguoiThue;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(int giaPhong) {
        this.giaPhong = giaPhong;
    }

    public String getNoiThatPhong() {
        return noiThatPhong;
    }

    public void setNoiThatPhong(String noiThatPhong) {
        this.noiThatPhong = noiThatPhong;
    }

    public String getHienTrang() {
        return hienTrang;
    }

    public void setHienTrang(String hienTrang) {
        this.hienTrang = hienTrang;
    }

    public int getSoXe() {
        return soXe;
    }

    public void setSoXe(int soXe) {
        this.soXe = soXe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "ChuNhaID")
    private ChuNha chuNha;
    
    @ManyToOne
    @JoinColumn(name = "PhongID")
    private Phong phong;
    
    @ManyToOne
    @JoinColumn(name = "NguoiThueID")
    private NguoiThue nguoiThue;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "GiaPhong")
    private int giaPhong;
    
    @Column(name = "NoiThatPhong")
    private String noiThatPhong;
    
    @Column(name = "HienTrang")
    private String hienTrang;
    
    @Column(name = "SoXe")
    private int soXe;
    
    @Column(name = "NoiDung")
    private String noiDung;
    
    @Column(name ="NgayBatDau")
    private Date ngayBatDau;
    
    @Column(name ="NgayHetHan")
    private Date ngayHetHan;
    
    @Column(name ="NgaySua")
    private Date ngaySua;
    
    @Column(name ="TrangThai")
    private String trangThai;
    
    public HopDong(){
    }
}
