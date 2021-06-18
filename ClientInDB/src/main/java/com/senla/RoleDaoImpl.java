package com.senla;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository

public class RoleDaoImpl implements RoleDao{

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    public RoleDaoImpl() {
    }

    @Override
    public List<Role> getAllRoles() {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> query=criteriaBuilder.createQuery(Role.class);
        Root<Role> roleRoot = query.from(Role.class);
        query.select(roleRoot);
        return entityManager.createQuery(query).getResultList();
    }
}
