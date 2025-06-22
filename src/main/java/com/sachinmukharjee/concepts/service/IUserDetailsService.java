package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.UserRegister;
import com.sachinmukharjee.concepts.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserDetailsService extends UserDetailsService {

    public Users save(UserRegister userRegister);
}
