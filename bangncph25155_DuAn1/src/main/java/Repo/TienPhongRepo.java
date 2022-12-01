/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import HibernateUntils.HibernateUtils;
import Models.Phong;
import Models.TienPhong;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
       
    public UUID findByIdTienPhong(String ten) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.id from TienPhong p where p.ma = :ma";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public UUID findByIdChiTietTienPhong(String ten) {
        UUID uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.id from ChiTietTienPhong p where p.tienPhong.ma = :ma";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public Long findTienPhong(String ten) {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select Sum(p.giaPhong)/COUNT(p.giaPhong) from HopDong p where p.phong.tenPhong = :tenPhong ";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            query.setParameter("tenPhong", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public String findTenPhong(String ten) {
        String uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select p.phong.tenPhong from HopDong p where p.nguoiThue.ma = :ma";
            TypedQuery<String> query = session.createQuery(statement, String.class);
            query.setParameter("ma", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Long TongDichVu(String ten) {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select sum(p.donGia) from DichVuPhong p where p.phong.tenPhong = :ten";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            query.setParameter("ten", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Long Dien( String tenDichVu) {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select sum(p.donGia) from DichVu p where p.tenDichVu = :tenDichVu";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            query.setParameter("tenDichVu", tenDichVu);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Long Nuoc( String tenDichVu) {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select sum(p.donGia) from DichVu p where p.tenDichVu = :tenDichVu";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            query.setParameter("tenDichVu", tenDichVu);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public Integer checkTienThang(String ten, int ngayTao) {
        Integer uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select month(p.ngayTao) from TienPhong p where month(p.ngayTao)= :ngayTao and p.phong.tenPhong = :tenPhong";
            TypedQuery<Integer> query = session.createQuery(statement, Integer.class);
            query.setParameter("tenPhong", ten);
            query.setParameter("ngayTao", ngayTao);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public Integer checkNam(String ten, int ngayTao) {
        Integer uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select year(p.ngayTao) from TienPhong p where year(p.ngayTao)= :ngayTao and p.phong.tenPhong = :tenPhong";
            TypedQuery<Integer> query = session.createQuery(statement, Integer.class);
            query.setParameter("tenPhong", ten);
            query.setParameter("ngayTao", ngayTao);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public Long DemTienPhong() {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select Count(p.ma) from TienPhong p";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Long ThongKe(String trangThai, int thang, int nam) {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select sum(a.donGia) from ChiTietTienPhong a where a.tienPhong.trangThai = :trangThai and month(a.tienPhong.ngayTao) = :thang and year(a.tienPhong.ngayTao) = :nam";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            query.setParameter("trangThai", trangThai);
            query.setParameter("thang", thang);
            query.setParameter("nam", nam);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Long ThongKeTheoNam(String trangThai, int nam) {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select sum(a.donGia) from ChiTietTienPhong a where a.tienPhong.trangThai = :trangThai and year(a.tienPhong.ngayTao) = :nam";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            query.setParameter("trangThai", trangThai);
            query.setParameter("nam", nam);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Long ThongKeTheoNamTong(int nam) {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select sum(a.donGia) from ChiTietTienPhong a where year(a.tienPhong.ngayTao) = :nam";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            query.setParameter("nam", nam);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public Long ThongKeTong(int thang, int nam) {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select sum(a.donGia) from ChiTietTienPhong a where month(a.tienPhong.ngayTao) = :thang and year(a.tienPhong.ngayTao) = :nam";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            query.setParameter("thang", thang);
            query.setParameter("nam", nam);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    
    public List<String> listPhong(String tinhTrang) {
        ArrayList<String> list = new ArrayList<>();
        try ( Session s = HibernateUtils.getFACTORY().openSession()) {
            String sql = "select p.tenPhong from Phong p where p.tinhTrang = :tinhTrang";
            TypedQuery<String> query = s.createQuery(sql, String.class);
            query.setParameter("tinhTrang", tinhTrang);

            list = (ArrayList<String>) query.getResultList();                       
        }
        return list;
    }
    
    public static void main(String[] args) {
        TienPhongRepo tp = new TienPhongRepo();
        
        String tenPhong = "Da thanh toan";
        int thang  = 11;
        int nam  = 2022;
        System.out.println(tp.ThongKeTheoNam(tenPhong, nam));
//        tp.listCbbMs(tenPhong).forEach(o -> {
//            System.out.println(o);
//        });
    }
}
