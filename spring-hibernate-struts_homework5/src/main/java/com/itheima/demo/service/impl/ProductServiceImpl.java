package com.itheima.demo.service.impl;

import com.itheima.demo.dao.IProductDao;
import com.itheima.demo.entity.Product;
import com.itheima.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

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