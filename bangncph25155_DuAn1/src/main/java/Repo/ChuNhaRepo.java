/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repo;

import HibernateUntils.HibernateUtils;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author MSI
 */
public class ChuNhaRepo {
    public Long findSuCoNT(String ten) {
        Long uuid;
        try ( Session session = HibernateUtils.getFACTORY().openSession()) {
            String statement = "select Count(p.trangThai) from SuCoKH p where p.trangThai = :trangThai";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            query.setParameter("trangThai", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
}
