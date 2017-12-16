package com.itheima.struts.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.itheima.struts.dao.IProductDao;
import com.itheima.struts.dao.impl.ProductDaoImpl;
import com.itheima.struts.entity.Product;
import com.itheima.struts.service.IProductService;

public class ProductServiceImpl implements IProductService {
	
	private IProductDao productDao = new ProductDaoImpl();

	@Override
	public List<Product> getAll() {
		try {
			return productDao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
