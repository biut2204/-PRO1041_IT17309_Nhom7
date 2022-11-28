/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import HibernateUntils.HibernateUtils;
import Models.SuCoKH;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Thanh Giang
 */
public class SuCoKHRepo {

    public List<SuCoKH> getAllData() {
        List<SuCoKH> list = new ArrayList<>();
        Transaction t = null;
        Session session = HibernateUtils.getFACTORY().openSession();
        try {
            t = session.beginTransaction();
            list = session.createQuery("from SuCoKH").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return list;
    }

    public void save(SuCoKH sucokh) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.save(sucokh);
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

    public void update(SuCoKH sucokh) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.update(sucokh);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }
}
