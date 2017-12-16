package com.itheima.struts.dao;

import java.sql.SQLException;
import java.util.List;

import com.itheima.struts.entity.Product;

public interface IProductDao {

	List<Product> getAll() throws SQLException;

}
