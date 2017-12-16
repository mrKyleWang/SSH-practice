package com.itheima.struts.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.struts.dao.IUserDao;
import com.itheima.struts.entity.User;
import com.itheima.struts.utils.JdbcUtils;

public class UserDaoImpl implements IUserDao {

	@Override
	public User findUser(String username, String password) throws SQLException {
		String sql = "select * from user where username = ? and password = ?";
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
		User existUser = queryRunner.query(sql, new BeanHandler<User>(User.class), username, password);
		return existUser;
	}

}
