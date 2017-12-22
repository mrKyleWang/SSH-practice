package com.itheima.demo.service.impl;

import com.itheima.demo.dao.IUserDao;
import com.itheima.demo.entity.User;
import com.itheima.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

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
