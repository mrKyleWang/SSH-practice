package com.itheima.demo.service.impl;

import com.itheima.demo.dao.IProductDao;
import com.itheima.demo.dao.impl.ProductDaoImpl;
import com.itheima.demo.entity.Product;
import com.itheima.demo.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {

    private IProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> getAll() {
        try {
            return productDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer add(Product product) {
        try {
            return productDao.add(product);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}