package com.itheima.demo.dao;

import java.sql.SQLException;
import com.itheima.demo.entity.User;

public interface IUserDao {

	User findUser(String username, String password) throws SQLException, Exception;

}
