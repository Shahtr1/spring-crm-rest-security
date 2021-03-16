package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
