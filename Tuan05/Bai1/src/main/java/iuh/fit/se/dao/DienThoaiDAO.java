package iuh.fit.se.dao;

import iuh.fit.se.entity.DienThoai;
import iuh.fit.se.entity.NhaCungCap;
import iuh.fit.se.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class DienThoaiDAO {
    public List<DienThoai> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        return em.createQuery("SELECT d FROM DienThoai d", DienThoai.class).getResultList();
    }

    public List<DienThoai> getByNhaCungCap(String maNCC) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<DienThoai> q = em.createQuery(
                "SELECT d FROM DienThoai d WHERE d.nhaCungCap.maNCC = :ma", DienThoai.class);
        q.setParameter("ma", maNCC);
        return q.getResultList();
    }

    public boolean insert(DienThoai dt) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(dt);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean delete(String maDT) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            DienThoai dt = em.find(DienThoai.class, maDT);
            if (dt != null) em.remove(dt);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        } finally {
            em.close();
        }
    }
}
