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
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    
    public static void main(String[] args) {
        PhongRepo pR = new PhongRepo();
        String ten = "P101";
        Long list = pR.findSoNguoiHienCo(ten);
        System.out.println(list);
    }
}
