package com.nissum.user.dao;

import com.nissum.user.domain.UserDto;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Serializable save(UserDto user) {
        Serializable criteria = entityManager.unwrap(Session.class).save(user);
        return criteria;
    }

    public UserDto findById(Long id) {
        UserDto criteria = entityManager.find(UserDto.class,id);
        if(criteria==null){
            throw new EntityNotFoundException("Can't find id "
                    + id);
        }
        return criteria;
    }

    public boolean findByMail(String mail) {
        List criteria = entityManager.createQuery("SELECT p FROM UserDto p WHERE p.email IN:mail", UserDto.class).setParameter("mail", mail).getResultList();
         if(criteria==null){
             throw new EntityNotFoundException("Can't find email "
                     + mail);
         }
        return criteria.size()>0 ? true : false;
    }

}
