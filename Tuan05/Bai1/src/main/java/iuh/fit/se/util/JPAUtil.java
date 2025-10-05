package iuh.fit.se.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("QLDT_PU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
