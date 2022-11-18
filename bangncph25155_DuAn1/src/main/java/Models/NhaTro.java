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
@Table(name = "NhaTro")
public class NhaTro {

    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "ChuNhaID")
    private ChuNha chuNha;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "TenNha")
    private String tenNha;

    @Column(name = "DiaChi")
    private String diaChi;

    @OneToMany(mappedBy = "nhaTro",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Phong> phongs;

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

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenNha() {
        return tenNha;
    }

    public void setTenNha(String tenNha) {
        this.tenNha = tenNha;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public List<Phong> getPhongs() {
        return phongs;
    }

    public void setPhongs(List<Phong> phongs) {
        this.phongs = phongs;
    }

    public List<SuCoNhaTro> getSuCoNhaTros() {
        return suCoNhaTros;
    }

    public void setSuCoNhaTros(List<SuCoNhaTro> suCoNhaTros) {
        this.suCoNhaTros = suCoNhaTros;
    }

    public NhaTro(UUID id, ChuNha chuNha, String ma, String tenNha, String diaChi, List<Phong> phongs, List<SuCoNhaTro> suCoNhaTros) {
        this.id = id;
        this.chuNha = chuNha;
        this.ma = ma;
        this.tenNha = tenNha;
        this.diaChi = diaChi;
        this.phongs = phongs;
        this.suCoNhaTros = suCoNhaTros;
    }

    @OneToMany(mappedBy = "nhaTro",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SuCoNhaTro> suCoNhaTros;

    public NhaTro() {
    }

    
}
