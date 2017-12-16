package com.itheima.demo.service;

import com.itheima.demo.entity.User;

public interface IUserService {
	
	User findUser(String username, String password);

}
