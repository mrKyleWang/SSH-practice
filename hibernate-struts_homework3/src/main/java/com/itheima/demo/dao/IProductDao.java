package com.itheima.demo.dao;

import com.itheima.demo.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDao {

	List<Product> getAll() throws SQLException, Exception;

}
