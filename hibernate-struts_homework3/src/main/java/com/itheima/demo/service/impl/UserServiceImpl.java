package com.itheima.demo.service.impl;

import com.itheima.demo.dao.IUserDao;
import com.itheima.demo.dao.impl.UserDaoImpl;
import com.itheima.demo.entity.User;
import com.itheima.demo.service.IUserService;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao = new UserDaoImpl();

	@Override
	public User findUser(String username, String password) {
		
		try {
			return userDao.findUser(username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
