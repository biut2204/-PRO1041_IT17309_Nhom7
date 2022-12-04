/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import HibernateUntils.HibernateUtils;
import java.util.Date;
import java.util.UUID;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author MSI
 */
public class TraPhongRepo {
    
    public String findMaNguoiThue(String ten) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.ma from NguoiThue p where p.hoTen = :hoTen";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("hoTen", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public UUID findIdHopDong(String ten) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.id from HopDong p where p.nguoiThue.ma = :ma";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public String findMaHopDong(String ten) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.ma from HopDong p where p.nguoiThue.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public UUID findNguoiThue(String ten) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.id from NguoiThue p where p.ma = :ma";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public UUID findPhong(String ten) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.phong.id from HopDong p where p.nguoiThue.ma = :ma";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Integer findGiaPhong(String ten) {
        Integer uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.giaPhong from HopDong p where p.nguoiThue.ma = :ma";
            TypedQuery<Integer> query = session.createQuery(statement, Integer.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Integer findTienCoc(String ten) {
        Integer uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.tienCoc from HopDong p where p.nguoiThue.ma = :ma";
            TypedQuery<Integer> query = session.createQuery(statement, Integer.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public String findNoiThat(String ten) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.noiThatPhong from HopDong p where p.nguoiThue.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public String findHienTrangThue(String ten) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.hienTrang from HopDong p where p.nguoiThue.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public String findAnhHienTrangThue(String ten) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.anhHienTrang from HopDong p where p.nguoiThue.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Integer findSoXe(String ten) {
        Integer uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.soXe from HopDong p where p.nguoiThue.ma = :ma";
            TypedQuery<Integer> query = session.createQuery(statement, Integer.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public String findNoiDung(String ten) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.noiDung from HopDong p where p.nguoiThue.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Date findNgayBatDau(String ten) {
        Date uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.ngayBatDau from HopDong p where p.nguoiThue.ma = :ma";
            TypedQuery<Date> query = session.createQuery(statement, Date.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Date findNgayHetHan(String ten) {
        Date uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.ngayHetHan from HopDong p where p.nguoiThue.ma = :ma";
            TypedQuery<Date> query = session.createQuery(statement, Date.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public static void main(String[] args) {
        TraPhongRepo traphongR = new TraPhongRepo();
        String ten = "NT1";
        System.out.println(traphongR.findPhong(ten));
    }
}
