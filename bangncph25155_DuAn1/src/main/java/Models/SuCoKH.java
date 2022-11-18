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
@Table(name = "SuCoKH")
public class SuCoKH {
    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "PhongID")
    private Phong phong;
    
    @ManyToOne
    @JoinColumn(name = "ChuNhaID")
    private ChuNha chuNha;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "TenSuCo")
    private String tenSuCo;
    
    @Column(name = "ThoiGianThongBao")
    private Date thoiGianThongBao;
    
    @Column(name = "MoTa")
    private String moTa;
    
    @Column(name = "TrangThai")
    private String trangThai;

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

    public ChuNha getChuNha() {
        return chuNha;
    }

    public void setChuNha(ChuNha chuNha) {
        this.chuNha = chuNha;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenSuCo() {
        return tenSuCo;
    }

    public void setTenSuCo(String tenSuCo) {
        this.tenSuCo = tenSuCo;
    }

    public Date getThoiGianThongBao() {
        return thoiGianThongBao;
    }

    public void setThoiGianThongBao(Date thoiGianThongBao) {
        this.thoiGianThongBao = thoiGianThongBao;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public SuCoKH(UUID id, Phong phong, ChuNha chuNha, String ma, String tenSuCo, Date thoiGianThongBao, String moTa, String trangThai) {
        this.id = id;
        this.phong = phong;
        this.chuNha = chuNha;
        this.ma = ma;
        this.tenSuCo = tenSuCo;
        this.thoiGianThongBao = thoiGianThongBao;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }
}
