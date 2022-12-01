/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import HibernateUntils.HibernateUtils;
import Models.NhaTro;
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
public class NhaTroRepo {

    public List<NhaTro> getAllData() {
        List<NhaTro> list = new ArrayList<>();
        Transaction t = null;
        Session session = HibernateUtils.getFACTORY().openSession();
        try {
            t = session.beginTransaction();
            list = session.createQuery("from NhaTro").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return list;
    }

    public void save(NhaTro nhaTro) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.save(nhaTro);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }

    public void update(NhaTro nhaTro) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.update(nhaTro);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }

    public UUID findByIdCN(String ten) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select cn.id from ChuNha cn where cn.hoTen = :hoTen";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("hoTen", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public Long findSoHD() {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select Count(p.ma) from HopDong p ";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public String checkTenPhong(String ten) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select tenPhong from Phong p where p.tenPhong =:tenPhong";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("tenPhong", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public static void main(String[] args) {
        NhaTroRepo ntR = new NhaTroRepo();
//                System.out.println(ntR.findSoHD()+1);
        String tenphong = "123434";
        String a = ntR.checkTenPhong(tenphong);
        try {
            boolean ktra = a.equals(tenphong);
        } catch (Exception e) {
            System.out.println("thanh cong");
        }
        
      
        }
    }

