/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MSI
 */
@Entity
@Table(name = "NguoiThue")
public class NguoiThue {

    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private UUID id;

    @OneToMany(mappedBy = "nguoiThue",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TaiKhoan> taiKhoans;
    
    @OneToMany(mappedBy = "nguoiThue",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HopDong> hopDongs;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "Cmtnd")
    private String cmtnd;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<TaiKhoan> getTaiKhoans() {
        return taiKhoans;
    }

    public void setTaiKhoans(List<TaiKhoan> taiKhoans) {
        this.taiKhoans = taiKhoans;
    }

    public List<HopDong> getHopDongs() {
        return hopDongs;
    }

    public void setHopDongs(List<HopDong> hopDongs) {
        this.hopDongs = hopDongs;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCmtnd() {
        return cmtnd;
    }

    public void setCmtnd(String cmtnd) {
        this.cmtnd = cmtnd;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDiXe() {
        return diXe;
    }

    public void setDiXe(String diXe) {
        this.diXe = diXe;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public NguoiThue(UUID id, List<TaiKhoan> taiKhoans, List<HopDong> hopDongs, String ma, String hoTen, Date ngaySinh, String cmtnd, String gioiTinh, String sdt, String email, String diaChi, String diXe, String trangThai) {
        this.id = id;
        this.taiKhoans = taiKhoans;
        this.hopDongs = hopDongs;
        this.ma = ma;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.cmtnd = cmtnd;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.diXe = diXe;
        this.trangThai = trangThai;
    }
    
    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "Sdt")
    private String sdt;
    
    @Column(name = "Email")
    private String email;

    @Column(name = "DiaChi")
    private String diaChi;
    
    @Column(name = "DiXe")
    private String diXe;

    @Column(name = "TrangThai")
    private String trangThai;
    
    public NguoiThue(){
    } 
}
