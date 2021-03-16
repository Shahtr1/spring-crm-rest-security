package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entity.User;
import com.luv2code.springdemo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
