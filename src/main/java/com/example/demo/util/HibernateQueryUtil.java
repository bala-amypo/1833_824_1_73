package com.example.demo.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class HibernateQueryUtil {

    private HibernateQueryUtil() {
        // prevent object creation
    }

    /**
     * Create JPQL query
     */
    public static Query createQuery(EntityManager entityManager, String jpql) {
        return entityManager.createQuery(jpql);
    }

    /**
     * Create JPQL query with parameters
     */
    public static Query createQuery(
            EntityManager entityManager,
            String jpql,
            String paramName,
            Object paramValue
    ) {
        Query query = entityManager.createQuery(jpql);
        query.setParameter(paramName, paramValue);
        return query;
    }

    /**
     * Get result list safely
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> getResultList(Query query) {
        return query.getResultList();
    }

    /**
     * Get single result safely
     */
    public static Object getSingleResult(Query query) {
        return query.getSingleResult();
    }
}
