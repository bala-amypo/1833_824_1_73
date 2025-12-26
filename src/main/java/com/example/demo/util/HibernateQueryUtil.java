package com.example.demo.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class HibernateQueryUtil {

    private HibernateQueryUtil() {
    }

    public static <T> List<T> getResultList(EntityManager entityManager, String jpql, Class<T> clazz) {
        TypedQuery<T> query = entityManager.createQuery(jpql, clazz);
        return query.getResultList();
    }

    public static <T> T getSingleResult(EntityManager entityManager, String jpql, Class<T> clazz) {
        TypedQuery<T> query = entityManager.createQuery(jpql, clazz);
        return query.getSingleResult();
    }
}
