package com.senla;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public User findByUserName(String username){

        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query=criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);
        query.select(userRoot);
        User user=new User();
        List<User> userList=  entityManager.createQuery(query).getResultList();
        for (User us : userList) {
            System.out.println(us);
          if( us.getUsername().equals(username)){
              user=us;
          }
            System.out.println(user);
        }return user;
    }
    @Override
    public void delete(User user) {
        entityManager.remove(user);

    }

    @Override
    public void save(User user) {
       entityManager.persist(user);
    }
}
