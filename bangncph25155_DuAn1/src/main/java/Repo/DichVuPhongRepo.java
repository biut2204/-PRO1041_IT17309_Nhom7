/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import HibernateUntils.HibernateUtils;
import Models.DichVuPhong;
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
public class DichVuPhongRepo {

    Session session = HibernateUtils.getFACTORY().openSession();
    Transaction transaction = session.getTransaction();

    public List<DichVuPhong> getAllData() {
        List<DichVuPhong> list = new ArrayList<>();
        Transaction t = null;
        Session session = HibernateUtils.getFACTORY().openSession();
        try {
            t = session.beginTransaction();
            list = session.createQuery("from DichVuPhong").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return list;
    }

    public void save(DichVuPhong dvp) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.save(dvp);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }

    public void update(DichVuPhong dvp) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.update(dvp);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }

    public Boolean saveOrUpdate(DichVuPhong dvp) {
        try {
            transaction.begin();
            session.saveOrUpdate(dvp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public UUID findByIdDichVu(String ten) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select dv.id from DichVu dv where dv.tenDichVu = :tenDichVu";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("tenDichVu", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public Long DemDichVuPhong() {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select Count(p.ma) from DichVuPhong p";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public static void main(String[] args) {
        String tendv = "Tien dien";
        DichVuPhongRepo dvpR = new DichVuPhongRepo();
        System.out.println(dvpR.findByIdDichVu(tendv));
    }
}
