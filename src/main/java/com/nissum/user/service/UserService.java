package com.nissum.user.service;

import com.nissum.user.dao.UserDao;
import com.nissum.user.domain.UserDto;
import com.nissum.user.domain.UserRsDto;
import com.nissum.user.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.io.Serializable;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserDao userdao;


    public UserDto getUser(Long id) {
        UserDto rs = userdao.findById(id);
        return rs;
    }

    @Override
    public UserRsDto save(UserDto request) {
        boolean status = userdao.findByMail(request.getEmail());
        if(status){
            throw new EntityExistsException("El correo ya registrado."
                    + request.getEmail());
        }
        Serializable response = userdao.save(request);
        UserRsDto rs = new UserRsDto();
        rs.setId((Long)response);
        rs.setCreated(Util.formatDate(request.getCreated()));
        rs.setModified(Util.formatDate(request.getModified()));
        rs.setLast_login(Util.formatDate(request.getLast_login()));
        return rs;
    }


}
