/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MSI
 */
@Entity
@Table(name = "TienPhong")
public class TienPhong implements Serializable {
    
    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "PhongID")
    private Phong phong;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "HinhThucThanhToan")
    private String hinhThucThanhToan;
    
    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;
    
    @Column(name = "TrangThai")
    private String trangThai;
    
    @Column(name = "GhiChu")
    private String ghiChu;

    public TienPhong() {
        
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

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public List<ChiTietTienPhong> getChiTietTienPhongs() {
        return chiTietTienPhongs;
    }

    public void setChiTietTienPhongs(List<ChiTietTienPhong> chiTietTienPhongs) {
        this.chiTietTienPhongs = chiTietTienPhongs;
    }

    public TienPhong(UUID id, Phong phong, String ma, String hinhThucThanhToan, Date ngayThanhToan, String trangThai, String ghiChu, List<ChiTietTienPhong> chiTietTienPhongs) {
        this.id = id;
        this.phong = phong;
        this.ma = ma;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.chiTietTienPhongs = chiTietTienPhongs;
    }

    public TienPhong(UUID id, Phong phong, String ma, String hinhThucThanhToan, Date ngayThanhToan, String trangThai, String ghiChu) {
        this.id = id;
        this.phong = phong;
        this.ma = ma;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }
    
    @OneToMany(mappedBy = "tienPhong",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChiTietTienPhong> chiTietTienPhongs;

}
