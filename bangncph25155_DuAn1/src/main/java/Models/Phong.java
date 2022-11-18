/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

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
@Table(name = "Phong")
public class Phong {
    
    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "NhaTroID")
    private NhaTro nhaTro;
    
    @Column(name ="Ma")
    private String ma;
    
    @Column(name ="TenPhong")
    private String tenPhong;
    
    @Column(name ="DienTich")
    private float dienTich;
    
    @Column(name ="SoNguoiHienCo")
    private int soNguoiHienCo;
    
    @Column(name ="SoXe")
    private int soXe;
    
    @Column(name ="TinhTrang")
    private String tinhTrang;
    
    @OneToMany(mappedBy = "phong",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TienPhong> tienPhongs;
    
    @OneToMany(mappedBy = "phong",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SuCoKH> suCoKHs;
    
    @OneToMany(mappedBy = "phong",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HopDong> hopDongs;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public NhaTro getNhaTro() {
        return nhaTro;
    }

    public void setNhaTro(NhaTro nhaTro) {
        this.nhaTro = nhaTro;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }

    public int getSoNguoiHienCo() {
        return soNguoiHienCo;
    }

    public void setSoNguoiHienCo(int soNguoiHienCo) {
        this.soNguoiHienCo = soNguoiHienCo;
    }

    public int getSoXe() {
        return soXe;
    }

    public void setSoXe(int soXe) {
        this.soXe = soXe;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public List<TienPhong> getTienPhongs() {
        return tienPhongs;
    }

    public void setTienPhongs(List<TienPhong> tienPhongs) {
        this.tienPhongs = tienPhongs;
    }

    public List<SuCoKH> getSuCoKHs() {
        return suCoKHs;
    }

    public void setSuCoKHs(List<SuCoKH> suCoKHs) {
        this.suCoKHs = suCoKHs;
    }

    public List<HopDong> getHopDongs() {
        return hopDongs;
    }

    public void setHopDongs(List<HopDong> hopDongs) {
        this.hopDongs = hopDongs;
    }

    public Phong(UUID id, NhaTro nhaTro, String ma, String tenPhong, float dienTich, int soNguoiHienCo, int soXe, String tinhTrang, List<TienPhong> tienPhongs, List<SuCoKH> suCoKHs, List<HopDong> hopDongs) {
        this.id = id;
        this.nhaTro = nhaTro;
        this.ma = ma;
        this.tenPhong = tenPhong;
        this.dienTich = dienTich;
        this.soNguoiHienCo = soNguoiHienCo;
        this.soXe = soXe;
        this.tinhTrang = tinhTrang;
        this.tienPhongs = tienPhongs;
        this.suCoKHs = suCoKHs;
        this.hopDongs = hopDongs;
    }

    public Phong(){
    }

    
}
