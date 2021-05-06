package com.hibernate;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    @Getter
    private EntityManager entityManager;

    public EntityManagerUtil(){
        init();
    }
    public void init(){
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("persistence");
        this.entityManager= factory.createEntityManager();
    }
    public void commit(){
        entityManager.getTransaction().commit();
    }
    public void beginTransaction(){
        entityManager.getTransaction().begin();
    }
    public void rollback(){
        entityManager.getTransaction().rollback();
    }
}
