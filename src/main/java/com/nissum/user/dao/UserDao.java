package com.nissum.user.dao;

import com.nissum.user.domain.UserDto;
import org.hibernate.IdentifierLoadAccess;

import java.io.Serializable;

public interface UserDao {
    Serializable save(UserDto user);
    UserDto findById(Long id);
    boolean findByMail(String mail);
}
