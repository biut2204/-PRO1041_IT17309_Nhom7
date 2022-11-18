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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MSI
 */
@Entity
@Table(name = "ChuNha")
public class ChuNha {
    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private UUID id;
    
    @Column(name = "HoTen")
    private String hoTen;
    
    @Column(name = "Sdt")
    private String sdt;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @OneToMany(mappedBy = "chuNha",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TaiKhoan> taiKhoans;
    
    @OneToMany(mappedBy = "chuNha",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NhaTro> nhaTros;
    
    @OneToMany(mappedBy = "chuNha",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HopDong> hopDongs;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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

    public List<TaiKhoan> getTaiKhoans() {
        return taiKhoans;
    }

    public void setTaiKhoans(List<TaiKhoan> taiKhoans) {
        this.taiKhoans = taiKhoans;
    }

    public List<NhaTro> getNhaTros() {
        return nhaTros;
    }

    public void setNhaTros(List<NhaTro> nhaTros) {
        this.nhaTros = nhaTros;
    }

    public List<HopDong> getHopDongs() {
        return hopDongs;
    }

    public void setHopDongs(List<HopDong> hopDongs) {
        this.hopDongs = hopDongs;
    }

    public ChuNha(UUID id, String hoTen, String sdt, String email, String diaChi, List<TaiKhoan> taiKhoans, List<NhaTro> nhaTros, List<HopDong> hopDongs) {
        this.id = id;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.taiKhoans = taiKhoans;
        this.nhaTros = nhaTros;
        this.hopDongs = hopDongs;
    }
    
    public ChuNha(){
    }
}
