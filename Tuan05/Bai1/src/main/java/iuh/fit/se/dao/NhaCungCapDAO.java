package iuh.fit.dao;

import iuh.fit.se.entity.NhaCungCap;
import iuh.fit.se.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class NhaCungCapDAO {
    public List<NhaCungCap> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        return em.createQuery("SELECT n FROM NhaCungCap n", NhaCungCap.class)
                .getResultList();
    }

    public NhaCungCap findById(String id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(NhaCungCap.class, id);
    }

    public List<NhaCungCap> search(String keyword) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<NhaCungCap> q = em.createQuery(
                "SELECT n FROM NhaCungCap n WHERE " +
                        "n.maNCC LIKE :kw OR n.tenNhaCC LIKE :kw OR n.diaChi LIKE :kw OR n.soDienThoai LIKE :kw",
                NhaCungCap.class);
        q.setParameter("kw", "%" + keyword + "%");
        return q.getResultList();
    }
}
