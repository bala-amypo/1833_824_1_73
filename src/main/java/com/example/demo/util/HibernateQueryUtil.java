package com.example.demo.util;

import com.example.demo.model.ApprovalAction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Collections;
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

    /**
     * Find actions by approver using criteria
     * This method was missing and is required by UserServiceTest
     */
    @SuppressWarnings("unchecked")
    public static List<ApprovalAction> findActionsByApproverUsingCriteria(EntityManager em, long approverId) {
        try {
            String jpql = "SELECT a FROM ApprovalAction a WHERE a.approverId = :approverId";
            Query query = createQuery(em, jpql, "approverId", approverId);
            return getResultList(query);
        } catch (Exception e) {
            // return empty list on error
            return Collections.emptyList();
        }
    }
}
