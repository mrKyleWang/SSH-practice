package com.itheima.struts.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.struts.dao.IProductDao;
import com.itheima.struts.entity.Product;
import com.itheima.struts.utils.JdbcUtils;

public class ProductDaoImpl implements IProductDao {

	@Override
	public List<Product> getAll() throws SQLException {
		String sql= "select * from product";
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}

}
