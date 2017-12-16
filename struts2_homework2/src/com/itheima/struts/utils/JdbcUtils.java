package com.itheima.struts.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {

	private static DataSource dataSource = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
