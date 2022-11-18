/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import HibernateUntils.HibernateUtils;
import Models.TienPhong;
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
public class TienPhongRepo {
    public List<TienPhong> getAllData() {
        List<TienPhong> list = new ArrayList<>();
        Transaction t = null;
        Session session = HibernateUtils.getFACTORY().openSession();
        try {
            t = session.beginTransaction();
            list = session.createQuery("from TienPhong").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return list;
    }

    public void save(TienPhong tienPhong) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.save(tienPhong);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }
    
    public void update(TienPhong tienPhong) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.update(tienPhong);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }
    
    public UUID findByIdPhong(String ten) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.id from Phong p where p.tenPhong = :tenPhong";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("tenPhong", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Integer findTienPhong(String ten) {
        Integer uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.giaPhong from Phong p where p.tenPhong = :tenPhong ";
            TypedQuery<Integer> query = session.createQuery(statement, Integer.class);
            query.setParameter("tenPhong", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public static void main(String[] args) {
        TienPhongRepo tp = new TienPhongRepo();
        String  tenPhong= "P101";
        int a = tp.findTienPhong(tenPhong);
        System.out.println(a);
    }
}
