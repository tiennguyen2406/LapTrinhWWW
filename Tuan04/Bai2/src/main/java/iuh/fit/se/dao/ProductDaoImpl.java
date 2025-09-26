package iuh.fit.se.dao;

import iuh.fit.se.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("shopPU");

    @Override
    public List<Product> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Product> list = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        em.close();
        return list;
    }

    @Override
    public Product findById(String id) {
        EntityManager em = emf.createEntityManager();
        Product p = em.find(Product.class, id);
        em.close();
        return p;
    }
}
