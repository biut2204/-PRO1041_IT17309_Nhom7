/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import HibernateUntils.HibernateUtils;
import Models.TaiKhoan;
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
public class TaiKhoanRepo {

    public String findById(String tenTaiKhoan, String matKhau) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select vaiTro from TaiKhoan tk where tk.tenTaiKhoan = :tenTaiKhoan and tk.matKhau = :matKhau";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("tenTaiKhoan", tenTaiKhoan);
            query.setParameter("matKhau", matKhau);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public UUID findByTen(String hoTen) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select nt.id from NguoiThue nt where nt.hoTen = :hoTen";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("hoTen", hoTen);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public String findByIdNguoiThue(String tenTaiKhoan, String matKhau) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select tk.nguoiThue.ma from TaiKhoan tk where tk.tenTaiKhoan = :tenTaiKhoan and tk.matKhau = :matKhau";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("tenTaiKhoan", tenTaiKhoan);
            query.setParameter("matKhau", matKhau);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public String check(String tenTaiKhoan) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select tk.nguoiThue.ma from TaiKhoan tk where tk.tenTaiKhoan = :tenTaiKhoan";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("tenTaiKhoan", tenTaiKhoan);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public List<TaiKhoan> getAllData() {
        List<TaiKhoan> list = new ArrayList<>();
        Transaction t = null;
        Session session = HibernateUtils.getFACTORY().openSession();
        try {
            t = session.beginTransaction();
            list = session.createQuery("from TaiKhoan").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return list;
    }

    public void save(TaiKhoan tk) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.save(tk);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }

    public void update(TaiKhoan tk) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.update(tk);
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
