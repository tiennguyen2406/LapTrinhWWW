package iuh.fit.se.dao;

import iuh.fit.se.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("userPU");
    @Override
    public User findUserByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email",User.class);
            query.setParameter("email", email);
            return query.getResultStream().findFirst().orElse(null);
        }finally {
            em.close();
        }
    }

    @Override
    public boolean create(User user) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }finally{
            em.close();
        }
    }

    @Override
    public List<User> findAll() {
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("SELECT u FROM User u", User.class).getResultList();
        }finally {
            em.close();
        }
    }
}
