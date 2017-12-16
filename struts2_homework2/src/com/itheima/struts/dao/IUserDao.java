package com.itheima.struts.dao;

import java.sql.SQLException;
import com.itheima.struts.entity.User;

public interface IUserDao {

	User findUser(String username, String password) throws SQLException;

}
