/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import HibernateUntils.HibernateUtils;
import Models.Phong;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author MSI
 */
public class PhongRepo {
    public List<Phong> getAllData() {
        List<Phong> list = new ArrayList<>();
        Transaction t = null;
        Session session = HibernateUtils.getFACTORY().openSession();
        try {
            t = session.beginTransaction();
            list = session.createQuery("from Phong").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return list;
    }

    public void save(Phong phong) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.save(phong);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }
    
    public void update(Phong phong) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.update(phong);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }
    
    public UUID findByIdNT(String ten) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select nt.id from NguoiThue nt where nt.hoTen = :hoTen";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("hoTen", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public UUID findByIdNhaTro(String ten) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select nt.id from NhaTro nt where nt.tenNha = :tenNha";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("tenNha", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Long findSoNguoiHienCo(String ten) {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select Count(tenPhong) from Phong p where p.tenPhong = :tenPhong";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            query.setParameter("tenPhong", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Long findXeHienCo(String ten, String diXe) {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select Count(p.nguoiThue.diXe) from Phong p where p.tenPhong = :tenPhong and p.nguoiThue.diXe =: diXe ";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            query.setParameter("tenPhong", ten);
            query.setParameter("diXe", diXe);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public String findMaPhong(String ten) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.ma from Phong p where p.tenPhong = :tenPhong";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("tenPhong", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Float findDienTichPhong(String ten) {
        Float uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.dienTich from Phong p where p.tenPhong = :tenPhong";
            TypedQuery<Float> query = session.createQuery(statement, Float.class);
            query.setParameter("tenPhong", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public String findAnhPhong(String ten) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.anhPhong from Phong p where p.tenPhong = :tenPhong";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("tenPhong", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public String findMaHopDong(String ten) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.ma from HopDong p where p.nguoiThue.hoTen = :hoTen";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("hoTen", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public List<Phong> test(float ten, float diXe) {
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "FROM Phong E WHERE E.dienTich >= :ten and E.dienTich <= :diXe";
            
            Query query = session.createQuery(hql);
            query.setParameter("ten", ten);
            query.setParameter("diXe", diXe);

            List results = query.list();
            return results;
        }
    }
    
    public UUID findByIdPHopDong(String ten) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.id from HopDong p where p.nguoiThue.hoTen = :hoTen";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("hoTen", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    
    public static void main(String[] args) {
        PhongRepo pR = new PhongRepo();
        String ten = "P101";
        System.out.println(pR.findDienTichPhong(ten));
    }
}
