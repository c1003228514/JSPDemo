package com.cyt.jsp.dao;

import com.cyt.jsp.entity.User;

public interface IUserDao {

	public User selectUserByName(String name);
	
}
