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
public class UserDao implements UserRepository {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;


    @Override
    public User getUserByUsername(String username) {
        return null;
    }
    @Override
    public List<User> getUserList() {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query=criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);
        query.select(userRoot);
        System.out.println("aaaaaaaa");
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public User getUserByName(String name){
        List<User> userList=getUserList();
        User user   =new User();
        for (User user1:userList) {
            if(user1.getUsername().equals(name)){
                user=user1;
            }
        }
        return user;
    }

}
