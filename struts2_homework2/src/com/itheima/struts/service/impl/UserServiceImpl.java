package com.itheima.struts.service.impl;

import java.sql.SQLException;

import com.itheima.struts.dao.IUserDao;
import com.itheima.struts.dao.impl.UserDaoImpl;
import com.itheima.struts.entity.User;
import com.itheima.struts.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao = new UserDaoImpl();
	
	public User findUser(String username, String password) {
		
		try {
			return userDao.findUser(username, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
