package com.dao;

import com.hibernate.EntityManagerUtil;
import com.model.AEntity;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class AbstractDao<T extends AEntity> {
    protected EntityManager entityManager;
    protected EntityManagerUtil entityManagerUtil;

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public T getById(Integer id) {
        return entityManager.find(getClazz(), id);
    }

    public List<T> getAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getClazz());
        return entityManager.createQuery(query).getResultList();
    }

    protected abstract Class<T> getClazz();

}
