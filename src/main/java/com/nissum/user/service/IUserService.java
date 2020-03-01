package com.nissum.user.service;

import com.nissum.user.domain.UserDto;
import com.nissum.user.domain.UserRsDto;

public interface IUserService {
    UserDto getUser(Long id);
    UserRsDto save(UserDto user);
}
