package com.itheima.struts.service;

import com.itheima.struts.entity.User;

public interface IUserService {
	
	User findUser(String username, String password);

}
