package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
