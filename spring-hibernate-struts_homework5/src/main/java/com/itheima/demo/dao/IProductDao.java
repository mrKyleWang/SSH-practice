package com.itheima.demo.dao;

import com.itheima.demo.entity.Product;

import java.util.List;

public interface IProductDao {

    List<Product> getAll() throws Exception;

    Integer add(Product product) throws Exception;
}
