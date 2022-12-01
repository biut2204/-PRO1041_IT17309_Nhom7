/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import HibernateUntils.HibernateUtils;
import Models.NguoiThue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MSI
 */
public class NguoiThueRepo {

    public String findHoTen(String id) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select hoTen from NguoiThue nt where nt.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", id);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public Date findNgaySinh(String id) {
        Date uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select ngaySinh from NguoiThue nt where nt.ma = :ma";
            TypedQuery<Date> query = session.createQuery(statement, Date.class);
            query.setParameter("ma", id);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public String findGioiTinh(String id) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select gioiTinh from NguoiThue nt where nt.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", id);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public String findSdt(String id) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select sdt from NguoiThue nt where nt.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", id);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public String findDiaChi(String id) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select diaChi from NguoiThue nt where nt.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", id);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public String findDiXe(String id) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select diXe from NguoiThue nt where nt.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", id);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public String findTrangThai(String id) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select trangThai from NguoiThue nt where nt.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", id);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public void save(NguoiThue nt) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.save(nt);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }

    public List<NguoiThue> getAlldata() {
        List<NguoiThue> list = new ArrayList<>();
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            list = s.createQuery("from NguoiThue").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.flush();;
            s.close();
        }
        return list;
    }

    public void update(NguoiThue nt) {
        Transaction t = null;
        Session s = HibernateUtils.getFACTORY().openSession();
        try {
            t = s.beginTransaction();
            s.update(nt);
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
        } finally {
            s.flush();
            s.close();
        }
    }

    public Long findSo() {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select Count(p.ma) from SuCoKH p ";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public Long findcmtnd() {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select cmtnd from NguoiThue nt where nt.ma = :ma ";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public String findmk(String id) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select tk.matKhau from TaiKhoan tk where tk.nguoiThue.ma = :ma ";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", id);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
        public UUID findidTK(String id) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select tk.id from TaiKhoan tk where tk.nguoiThue.ma = :ma ";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("ma", id);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
                public UUID findidNguoiThue(String id) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select nt.id from NguoiThue nt where nt.ma = :ma ";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("ma", id);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
                    public String findVaiTro(String id) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select tk.vaiTro from TaiKhoan tk where tk.nguoiThue.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", id);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
                                        public String findTenTK(String id) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select tk.tenTaiKhoan from TaiKhoan tk where tk.nguoiThue.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", id);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
                                            public String checkHoTen(String ten) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select hoTen from NguoiThue nt where nt.hoTen =:hoTen";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("hoTen", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
                                        
//        public String findHoTen(String id) {
//        String uuid;
//        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
//            String statement = "select hoTen from NguoiThue nt where nt.ma = :ma";
//            TypedQuery<String> query = session.createQuery(statement, String.class);
//            query.setParameter("ma", id);
//            uuid = query.getSingleResult();
//        }
//        return uuid;
//    }

    public static void main(String[] args) {
        NguoiThueRepo ntR = new NguoiThueRepo();
//        System.out.println(ntR.findSo());
        String ma = "ab";
        System.out.println(ntR.findidNguoiThue(ma));
    }
}
